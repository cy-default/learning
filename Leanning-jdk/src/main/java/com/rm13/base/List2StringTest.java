package com.rm13.base;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/20
 */
public class List2StringTest {

    public static void main(String[] args) {

        demo1();
        System.out.println("===========");
        demo2();
    }


    public static void demo1(){
        // List to String
        final List<String> strings = Arrays.asList("111", "222");
        System.out.println(String.join("','", strings));
        final StringJoiner joiner = new StringJoiner("','", "'", "'");
        for (String string : strings) {
            joiner.add(string);
        }
        System.out.println(joiner.toString());
    }

    public static void demo2(){
        final List<String> strings = Arrays.asList("111", "222");
        final String result = strings.stream().collect(Collectors.joining("','", "'", "'"));
        System.out.println(result);
    }
}
