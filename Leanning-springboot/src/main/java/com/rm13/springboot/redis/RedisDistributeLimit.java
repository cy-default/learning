package com.rm13.springboot.redis;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Optional;

/**
 * 分布式限流
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-10
 */
@Slf4j
public class RedisDistributeLimit {

    /**
     * lua脚本
     */
    private static final DefaultRedisScript<String> LIMIT_LUA;

    /**
     * prefix
     */
    private static final String LIMIT_HEARD = "limit:";

    /**
     *
     */
    private RedisTemplate redisTemplate;

    public RedisDistributeLimit(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }



    public boolean limitHandler(String key, Long capacity, Long intervalTime, Long expireTime) {
        try {
            Object execute = this.redisTemplate.execute((RedisCallback) (connection) -> {
                return connection.eval(LIMIT_LUA.getScriptAsString().getBytes(), ReturnType.INTEGER, 1, new byte[][]{buildLimitKey(key).getBytes(), capacity.toString().getBytes(), intervalTime.toString().getBytes(), expireTime.toString().getBytes()});
            });
            return execute.equals(1L);
        } catch (Exception var6) {
            log.error("limitHandler occured an exception", var6);
            return false;
        }
    }

    private String buildLimitKey(String key) {
        return "limit:" + key;
    }


    static {
        StringBuilder sb = new StringBuilder();
        sb.append("local key = KEYS[1] ");
        sb.append("local capacity = tonumber(ARGV[1]) ");
        sb.append("local intervalTime = tonumber(ARGV[2]) ");
        sb.append("local expireTime = tonumber(ARGV[3]) ");
        sb.append("local ttlTime = redis.call(\"pttl\",key) ");
        sb.append("local sum = math.floor((expireTime - ttlTime) / intervalTime) ");
        sb.append("if sum > 0 then ");
        sb.append("    if redis.call(\"incrby\",key,sum) > capacity then ");
        sb.append("        redis.call(\"set\",key,capacity) ");
        sb.append("    end ");
        sb.append("    redis.call(\"pexpire\",key,expireTime) ");
        sb.append("end ");
        sb.append("if redis.call(\"decr\",key) >= 0 ");
        sb.append("        then ");
        sb.append("    return 1 ");
        sb.append("else ");
        sb.append("    redis.call(\"incr\",key) ");
        sb.append("    return 0 ");
        sb.append("end ");
        DefaultRedisScript<String> script = new DefaultRedisScript();
        script.setScriptText(sb.toString());
        LIMIT_LUA = script;
    }
}
