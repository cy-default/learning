package com.rm13.cloud.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /*
    @Bean("redisCacheManager")
    public CacheManager dataCacheManager(RedisTemplate redisTemplate){
        final RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(60);
        redisCacheManager.setUsePrefix(true);
        return redisCacheManager;
    }
     */

    @Bean(value = "cacheKeyGenerator")
    public KeyGenerator cacheKeyGenerator() {
        return (target, method, params) -> {
            final List<Object> objects = Arrays.asList(params);
            return JSON.toJSONString(objects);
        };
    }

    @Bean(value = "dataCacheManager")
    public CacheManager dataCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        return cacheManager;
    }
}
