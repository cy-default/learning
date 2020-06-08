package com.rm13.cloud.ratelimit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/5
 */
// @Component
public class RedisLimitUtils {
    private static final Logger log = LoggerFactory.getLogger(RedisLimitUtils.class);
    private static final DefaultRedisScript<String> LIMIT_LUA;
    private static final String LIMIT_HEARD = "limit:";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public RedisLimitUtils() {
    }

    public boolean limitHandler(String key, Long capacity, Long intervalTime, Long expireTime) {
        try {
            Object execute = this.redisTemplate.execute((RedisCallback<Object>) (connection) -> {
                return connection.eval(LIMIT_LUA.getScriptAsString().getBytes(), ReturnType.INTEGER, 1, new byte[][]{this.buildLimitKey(key).getBytes(), capacity.toString().getBytes(), intervalTime.toString().getBytes(), expireTime.toString().getBytes()});
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
