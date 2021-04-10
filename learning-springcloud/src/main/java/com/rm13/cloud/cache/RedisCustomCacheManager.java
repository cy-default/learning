package com.rm13.cloud.cache;

import cn.hutool.core.util.StrUtil;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;

import java.time.Duration;

/**
 * 自定义redisCacheManager；
 * 1： 实现多租户；
 * 2： 实现方法级别的过期时间设置；
 *
 * @Author: chenyuan
 * @Date: 2021/4/6 下午4:59
 */
public class RedisCustomCacheManager extends RedisCacheManager {
	private static final String SPLIT_FLAG = "#";
	private static final int CACHE_LENGTH = 2;

	public RedisCustomCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
		super(cacheWriter, defaultCacheConfiguration);
	}

	/**
	 * 支持多租户
	 *
	 * @param name
	 * @return
	 */
	@Override
	public Cache getCache(String name) {
		return super.getCache(TenantContextHolder.getTenantId() + StrUtil.COLON + name);
	}

	/**
	 * 支持方法级别的过期时间设置
	 * <p>
	 * Cacheable(value = "menu_details#2000", key = "#roleId  + '_menu'")
	 * <p/>
	 *
	 * @param name
	 * @param cacheConfig
	 * @return
	 */
	@Override
	protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
		// name = menu_details#2000;
		if (StrUtil.isBlank(name) || !name.contains(SPLIT_FLAG)) {
			return super.createRedisCache(name, cacheConfig);
		}
		String[] cacheArray = name.split(SPLIT_FLAG);
		if (cacheArray.length < CACHE_LENGTH) {
			return super.createRedisCache(name, cacheConfig);
		}
		if (cacheConfig != null) {
			long cacheAge = Long.parseLong(cacheArray[1]);
			cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(cacheAge));
		}
		return super.createRedisCache(name, cacheConfig);
	}
}
