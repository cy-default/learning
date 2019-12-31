package com.rm13.shiro.config;

import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.rm13.shiro.model.generator.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 缓存 认证信息, 授权信息, 会话信息
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Slf4j
public class ShiroRedisCache<K, V> implements Cache<K, V> {

    /**
     * static final constant value
     */
    // seconds
    public static final int DEFAULT_EXPIRE = 30 * 60 ;
    public static final String DEFAULT_CACHE_KEY_PREFIX = "snmt:admin:shiro:";

    /**
     *
     */
    private int expire = DEFAULT_EXPIRE;
    private String cacheKey = DEFAULT_CACHE_KEY_PREFIX;
    private RedisTemplate<K, V> redisTemplate;

    public ShiroRedisCache(int expire, String name, RedisTemplate<K, V> redisTemplate) {
        this.expire = expire;
        this.cacheKey = String.format("%s%s:", DEFAULT_CACHE_KEY_PREFIX, name);
        this.redisTemplate = redisTemplate;
    }

    public ShiroRedisCache(String name, RedisTemplate<K, V> redisTemplate) {
        this.cacheKey = String.format("%s%s:", DEFAULT_CACHE_KEY_PREFIX, name);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) throws CacheException {
        log.info("从缓存中获取key为{}的缓存信息",getCacheKey(key));
        if( key == null ){
            return null;
        }
        // 设置过期时间
        redisTemplate.boundValueOps(getCacheKey(key)).expire(expire, TimeUnit.SECONDS);
        final V result = (V)redisTemplate.boundValueOps(getCacheKey(key)).get();
        return result;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        log.info("创建新的缓存，信息为：{}={}",getCacheKey(key),value);
        if(key == null || value == null){
            return null;
        }
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        redisTemplate.boundValueOps(getCacheKey(key)).expire(expire, TimeUnit.SECONDS);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        if( key == null ){
            return null;
        }
        log.info("移除key为{}的缓存", getCacheKey(key));
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        log.info("清空所有的缓存");
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        K key = getCacheKey2("*");
        final Set keys = redisTemplate.keys(key);
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }


    private K getCacheKey2(String key) {
        String result = this.cacheKey + key;
        return (K)result;
    }

    private K getCacheKey(K key) {
        String result;
        if(key instanceof User){
            result = this.cacheKey+((User) key).getUsername();
        }if(key instanceof PrincipalCollection){
            result = this.cacheKey+((User)((PrincipalCollection) key).getPrimaryPrincipal()).getUsername();
        } else{
            result = this.cacheKey + key.toString();
        }
        return (K)result;
    }
}
