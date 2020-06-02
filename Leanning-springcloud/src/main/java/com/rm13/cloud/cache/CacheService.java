package com.rm13.cloud.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
@Slf4j
@Service
public class CacheService {

    @Cacheable(value = "weekRank", keyGenerator = "cacheKeyGenerator", cacheManager = "dataCacheManager")
    public String cacheDemo() {
        String result = "cacheDemo=".concat(UUID.randomUUID().toString().replaceAll("-", ""));
        log.info(result);
        return result;
    }
}
