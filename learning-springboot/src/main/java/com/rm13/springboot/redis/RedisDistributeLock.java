package com.rm13.springboot.redis;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Optional;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-10
 */
@Slf4j
public class RedisDistributeLock {

    /**
     * lua脚本
     */
    private static final DefaultRedisScript<String> UNLOCK_LUA;

    /**
     * value
     */
    private static final String LOCK_VALUE = "1";

    /**
     * prefix key
     */
    private static final String LOCK_HEARD = "lock:";

    /**
     *
     */
    private RedisTemplate redisTemplate;

    public RedisDistributeLock(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private String buildKey(String key) {
        return "lock:" + key;
    }


    /**
     * 获取锁的value值
     * @param key
     * @return
     */
    public Optional<String> getLockValue(String key) {
        String o = (String)this.redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(o);
    }

    /**
     * 获取锁
     * @param key
     * @param value 为空时 使用当前线程值
     * @param expire 过期时间
     * @return
     */
    public boolean setLock(String key, String value, long expire) {
        if (StringUtils.isBlank(value)) {
            value = String.valueOf(Thread.currentThread().getId());
        }
        return this.setNX(key, value, expire);
    }

    /**
     * 获取锁， 使用当前线程值作为value
     * @param key
     * @param expire 过期时间
     * @return
     */
    public boolean setLock(String key, long expire) {
        final String value = String.valueOf(Thread.currentThread().getId());
        return this.setNX(key, value, expire);
    }

    /**
     * 获取锁
     * @param key
     * @param expire 过期时间
     * @param waitTime 等待时间（超过该时间设置不成功则返回失败）
     * @return
     */
    public boolean setLock(String key, long expire, long waitTime) {
        return this.setLock(key, (String)null, expire, waitTime);
    }


    /**
     * 获取锁
     * @param key
     * @param value
     * @param expire 过期时间
     * @param waitTime 等待时间（超过该时间设置不成功则返回失败）
     * @return
     */
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

    /**
     * 获取锁
     * @param key
     * @param value
     * @param expiredTime
     * @return
     */
    private boolean setNX(String key, String value, long expiredTime){
        Boolean resultBoolean = null;

        try {
            this.redisTemplate.execute((RedisCallback) redisConnection -> {
                final Object nativeConnection = redisConnection.getNativeConnection();
                String redisResult = "";
                RedisSerializer<String> stringRedisSerializer = redisTemplate.getKeySerializer();
                byte[] keyByte = stringRedisSerializer.serialize(key);
                byte[] valueByte = stringRedisSerializer.serialize(value);

                if (nativeConnection instanceof RedisAsyncCommands) {
                    RedisAsyncCommands commands = (RedisAsyncCommands) nativeConnection;
                    redisResult = commands.getStatefulConnection().sync().set(keyByte, valueByte, SetArgs.Builder.nx().px(expiredTime));
                } else if (nativeConnection instanceof RedisAdvancedClusterAsyncCommands) {
                    RedisAdvancedClusterAsyncCommands clusterAsyncCommands = (RedisAdvancedClusterAsyncCommands) nativeConnection;
                    redisResult = clusterAsyncCommands.getStatefulConnection().sync().set(keyByte, keyByte, SetArgs.Builder.nx().px(expiredTime));
                }

                return "OK".equalsIgnoreCase(redisResult);
            });
        }catch (Exception e) {
            log.error("RedisDistributeLock.setNX ERROR:{}", e.getMessage());
        }
        return resultBoolean != null && resultBoolean;
    }


    /**
     * 释放锁
     * @param key
     * @return
     */
    public boolean releaseLock(String key) {
        final String value = String.valueOf(Thread.currentThread().getId());
        return this.releaseLock(key, value);
    }

    /**
     * 释放锁
     * @param key
     * @param value
     * @return
     */
    public boolean releaseLock(String key, String value) {
        try {
            Object execute = this.redisTemplate.execute((RedisCallback)connection -> {
                return connection.eval(UNLOCK_LUA.getScriptAsString().getBytes(), ReturnType.INTEGER, 1, new byte[][]{key.getBytes(), value.getBytes()});
            });
            return execute.equals(1);
        } catch (Exception var4) {
            log.error("release lock occured an exception", var4);
            return false;
        }
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
