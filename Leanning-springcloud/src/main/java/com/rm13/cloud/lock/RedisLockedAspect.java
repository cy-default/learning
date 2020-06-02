package com.rm13.cloud.lock;

import com.rm13.cloud.common.ServiceException;
import com.rm13.cloud.common.constant.ExceptionDef;
import com.rm13.cloud.common.constant.RedisConstants;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.util.Collections;
import java.util.UUID;

@Aspect
// @Component
public class RedisLockedAspect {

    private static final Logger log = LoggerFactory.getLogger(RedisLockedAspect.class);

    private static final String UNLOCK_LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    // 使用redis分布式锁
    // http://www.redis.cn/commands/setnx.html
    @Around("execution(public * com.rm13.cloud.lock..*.*(..)) && @annotation(redisLocked)")
    public Object redisLock(ProceedingJoinPoint pjp, RedisLocked redisLocked) throws Throwable {
        String redisKey = parseKey(redisLocked.key(), pjp);
        String uuid = UUID.randomUUID().toString();
        boolean lockResult = lock(redisKey, uuid, redisLocked.timeout(), redisLocked.expire(), redisLocked.sleep(), redisLocked.isWait());
        if (!lockResult) {
            log.error("get lock failed : " + redisKey);
            throw new ServiceException(ExceptionDef.C500);
        }
        try {
            return pjp.proceed();
        } catch (Exception e) {
            log.error("redis lock 时业务异常", e);
            throw e;
        } finally {
            log.debug("release key: {}", redisKey);
            boolean releaseResult = unlock(redisKey, uuid);
            log.debug("release lock : " + redisKey + (releaseResult ? " success" : " failed"));
        }
    }

    private boolean lock(String redisKey, String uuid, long timeout, long expire, long sleep, boolean isWait) {
        long now = System.currentTimeMillis();
        boolean lockResult = setKeyToRedis(redisKey, uuid, expire);
        //如果获取锁失败，按照超时时限进行重试
        while (!lockResult && (System.currentTimeMillis() - now < timeout)) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                //do nothing here
                log.debug("Interrupted!", e);
                Thread.currentThread().interrupt();
            }
            lockResult = setKeyToRedis(redisKey, uuid, expire);
        }
        return lockResult;
    }

    private boolean setKeyToRedis(String redisKey, String uuid, long expire) {
        try {
            String result = redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    JedisCommands commands = (JedisCommands) redisConnection.getNativeConnection();
                    return commands.set(redisKey, uuid, "NX", "PX", expire);
                }
            });
            return !StringUtils.isEmpty(result);
        } catch (Exception e) {
            log.error("set redis occured an exception", e);
        }
        return false;
    }


    private boolean unlock(String redisKey, String uuid) {
        // 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
        try {
            // 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
            // spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本
            Long result = redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    Object nativeConnection = connection.getNativeConnection();
                    // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                    // 集群模式
                    if (nativeConnection instanceof JedisCluster) {
                        return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA, Collections.singletonList(redisKey), Collections.singletonList(uuid));
                    }

                    // 单机模式
                    else if (nativeConnection instanceof Jedis) {
                        return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, Collections.singletonList(redisKey), Collections.singletonList(uuid));
                    }
                    return 0L;
                }
            });
            return result != null && result > 0;
        } catch (Exception e) {
            log.error("release lock occured an exception", e);
        }
        return false;
    }

    /**
     * 获取缓存的key
     * key 定义在注解上，支持SPEL表达式
     */
    private String parseKey(String key, ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] paraNameArr = methodSignature.getParameterNames();

        Object[] args = pjp.getArgs();

        //使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        //SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        //把方法参数放入SPEL上下文中
        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }
        String value = key;
        try {
            Expression expression = parser.parseExpression(key);
            value = expression.getValue(context, String.class);
        } catch (Exception e) {
            log.error("分布式锁获取SPEL key失败, key:{}, 如非SPEL表达式, 可忽略, message:{}", key, e.getMessage());
        }
        return RedisConstants.LOCK_KEY + value;
    }
}
