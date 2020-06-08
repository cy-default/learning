package com.rm13.cloud.lock;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Optional;

/**
 * lettue springboot 2.x 实现分布式锁
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/5
 */
// @Component
public class RedisLockUtils {
    private static final Logger log = LoggerFactory.getLogger(RedisLockUtils.class);
    private static final DefaultRedisScript<String> UNLOCK_LUA;
    private static final String LOCK_VALUE = "1";
    private static final String LOCK_HEARD = "lock:";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisLockUtils() {
    }

    public boolean setLock(String key, String value, long expire) {
        if (StringUtils.isBlank(value)) {
            value = "1";
        }

        return this.setNx(buildKey(key), value, expire);
    }

    public boolean setLock(String key, long expire) {
        return this.setNx(key, (String)null, expire);
    }

    public boolean setLock(String key, long expire, long waitTime) {
        return this.setLock(key, (String)null, expire, waitTime);
    }

    public boolean setLock(String key, String value, long expire, long waitTime) {
        if (waitTime == 0L) {
            return this.setLock(key, value, expire);
        } else {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= waitTime) {
                if (this.setLock(key, value, expire)) {
                    return Boolean.TRUE;
                }
            }

            return false;
        }
    }

    public Optional<String> getLockValue(String key) {
        String o = (String)this.redisTemplate.opsForValue().get(buildKey(key));
        return Optional.ofNullable(o);
    }

    public boolean releaseLock(String key) {
        return this.releaseLock(key, "1");
    }

    public boolean releaseLock(String key, String value) {
        try {
            Object execute = this.redisTemplate.execute((RedisCallback<Object>) connection -> connection.eval(UNLOCK_LUA.getScriptAsString().getBytes(), ReturnType.INTEGER, 1, new byte[][]{RedisLockUtils.buildKey(key).getBytes(), value.getBytes()}));
            return execute.equals(1L);
        } catch (Exception var4) {
            log.error("release lock occured an exception", var4);
            return false;
        }
    }

    private boolean setNx(String key, String value, long expiredTime) {
        Boolean resultBoolean = null;

        try {
            resultBoolean = (Boolean)this.redisTemplate.execute((RedisCallback<Boolean>) (connection) -> {
                Object nativeConnection = connection.getNativeConnection();
                String redisResult = "";
                RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) this.redisTemplate.getKeySerializer();
                byte[] keyByte = stringRedisSerializer.serialize(key);
                byte[] valueByte = stringRedisSerializer.serialize(value);
                if (nativeConnection instanceof RedisAsyncCommands) {
                    RedisAsyncCommands commands = (RedisAsyncCommands)nativeConnection;
                    redisResult = commands.getStatefulConnection().sync().set(keyByte, valueByte, SetArgs.Builder.nx().px(expiredTime));
                }

                if (nativeConnection instanceof RedisAdvancedClusterAsyncCommands) {
                    RedisAdvancedClusterAsyncCommands clusterAsyncCommands = (RedisAdvancedClusterAsyncCommands)nativeConnection;
                    redisResult = clusterAsyncCommands.getStatefulConnection().sync().set(keyByte, keyByte, SetArgs.Builder.nx().px(expiredTime));
                }

                return "OK".equalsIgnoreCase(redisResult);
            });
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return resultBoolean != null && resultBoolean;
    }

    private static String buildKey(String key) {
        return "lock:" + key;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        DefaultRedisScript<String> script = new DefaultRedisScript();
        script.setScriptText(sb.toString());
        UNLOCK_LUA = script;
    }
}