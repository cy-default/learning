package com.rm13.shiro.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * shiro redis 缓存管理器
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
public class RedisCacheManager implements CacheManager {

    private RedisTemplate<String, Object> redisTemplate;
    // fast lookup by name map
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();
    private Object monitor = new Object();

    public RedisCacheManager(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Cache<String, Object> getCache(String name) throws CacheException {
        Cache<String, Object> cache = caches.get(name);
        if (cache != null) {
            return cache;
        }
        synchronized (monitor) {
            cache = caches.get(name);
            if (cache != null) {
                return cache;
            } else {
                cache = new RedisCache<String, Object>(name, redisTemplate);
                caches.put(name, cache);
            }
        }
        return cache;
    }
}
