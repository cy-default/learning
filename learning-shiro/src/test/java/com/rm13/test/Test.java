package com.rm13.test;

import com.rm13.shiro.LeanningShiroApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/5
 */

@SpringBootTest(classes = LeanningShiroApplication.class)
public class Test {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @org.junit.jupiter.api.Test
    public void redis() {

        final ZSetOperations<String, String> operations = stringRedisTemplate.opsForZSet();

        operations.add("snmt:rank", "cy1", 1);
        operations.add("snmt:rank", "cy2", 2);
        operations.add("snmt:rank", "cy3", 3);
        operations.add("snmt:rank", "cy4", 4);
        operations.add("snmt:rank", "cy5", 5);
        operations.add("snmt:rank", "cy6", 6);
        operations.add("snmt:rank", "cy7", 7);
        operations.add("snmt:rank", "cy8", 8);
        operations.add("snmt:rank", "cy9", 9);
        operations.add("snmt:rank", "cy10", 10);
        operations.add("snmt:rank", "cy11", 11);
        operations.add("snmt:rank", "cy12", 12);
        operations.add("snmt:rank", "cy13", 13);
        operations.add("snmt:rank", "cy14", 14);

        Set<String> strings = operations.reverseRange("snmt:rank", 0, 5);
        System.out.println(strings.getClass());
        System.out.println(strings);
    }
}
