package com.rm13.cloud.tmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/5
 */

@SpringBootTest
public class Test {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @org.junit.jupiter.api.Test
    public void redis() {

        final ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.setBit("snmt:bit", 10086, true);
        final Boolean bit = valueOperations.getBit("snmt:bit", 10086);
        System.out.println(bit);

        //////
        final ZSetOperations<String, String> zSetOperations = stringRedisTemplate.opsForZSet();
        zSetOperations.add("snmt:rank", "cy1", 1);
        zSetOperations.add("snmt:rank", "cy2", 2);
        zSetOperations.add("snmt:rank", "cy3", 3);
        zSetOperations.add("snmt:rank", "cy4", 4);
        zSetOperations.add("snmt:rank", "cy5", 5);
        zSetOperations.add("snmt:rank", "cy6", 6);
        zSetOperations.add("snmt:rank", "cy7", 7);
        zSetOperations.add("snmt:rank", "cy8", 8);
        zSetOperations.add("snmt:rank", "cy9", 9);
        zSetOperations.add("snmt:rank", "cy10", 10);
        zSetOperations.add("snmt:rank", "cy11", 11);
        zSetOperations.add("snmt:rank", "cy12", 12);
        zSetOperations.add("snmt:rank", "cy13", 13);
        zSetOperations.add("snmt:rank", "cy14", 14);
        System.out.println(zSetOperations.reverseRange("snmt:rank", 0, 9));

        //////
        final HyperLogLogOperations<String, String> hyperLogLogOperations = stringRedisTemplate.opsForHyperLogLog();
        hyperLogLogOperations.add("snmt:uv", "redis");
        hyperLogLogOperations.add("snmt:uv", "mysql");
        hyperLogLogOperations.add("snmt:uv", "redis");
        hyperLogLogOperations.add("snmt:uv", "rabbitmq");
        final Long size = hyperLogLogOperations.size("snmt:uv");
        System.out.println(size);
        //////

        final GeoOperations<String, String> geoOperations = stringRedisTemplate.opsForGeo();
        geoOperations.radius("snmt:radius", "mkl", 5000);

        //////
    }
}
