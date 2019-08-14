package com.rm13.util;

import com.rm13.UserEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-13
 */
public class Java8Stream {

    List<UserEntity> result = UserEntity.init();

    /**
     * 排序
     */
    @Test
    public void test1(){
        List<UserEntity> tmp =  result.stream().sorted(Comparator.comparing(UserEntity::getAge)).collect(Collectors.toList());
        System.out.println(tmp);
    }

    /**
     * 去重
     */
    @Test
    public void test2(){
        List<UserEntity> tmp = result.stream().distinct().collect(Collectors.toList());
        System.out.println(tmp);
    }

    /**
     * 分组
     * List -》 Map
     */
    @Test
    public void test3(){
        Map<String, List<UserEntity>> tmp = result.stream().distinct().collect(Collectors.groupingBy(UserEntity::getCity));
        System.out.println(tmp);
    }

    /**
     * 转换
     * List -> Map
     */
    @Test
    public void test4(){
        Map<String, UserEntity> tmp = result.stream().distinct().collect(Collectors.toMap(UserEntity::getName,Function.identity()));
        System.out.println(tmp);
    }

    /**
     * 拼接字符串
     */
    @Test
    public void test5(){
        String tmp = result.stream().map(UserEntity::getName).collect(Collectors.joining(","));
        System.out.println(tmp);
    }
}
