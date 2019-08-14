package com.rm13.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * String 字符串拼接
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-12
 */
public class Java8String {

    /**
     * java1.8
     */
    @Test
    public void test1() {
        String[] arr = new String[]{"aa", "bb", "cc"};
        System.out.println(String.join(",", arr));
        System.out.println(String.join(",", "dd","ee","ff"));

    }


    @Test
    public void test2() {
        String[] arr = new String[]{"aa", "bb", "cc"};

        List<String> list = Arrays.asList(arr);

        //最传统写法：
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }

        System.out.println(sb.toString());

        //如果想要加个分隔符，比如逗号，传统写法：
        sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));

            if(i < list.size() - 1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());

        //使用commons-lang库写法, 其实这个已经够简单了，就这个功能而言，我很喜欢，而且最最常用：
        System.out.println(StringUtils.join(list.toArray(), ","));

        //进入jdk8时代：
        System.out.println(list.stream().collect(Collectors.joining()));
        //jdk8时代，加个分隔符：
        System.out.println(list.stream().collect(Collectors.joining(",")));

        //jdk8时代，加个分隔符：
        System.out.println(String.join(",", list));

        list = list.stream().map(t-> "'".concat(t).concat("'")).collect(Collectors.toList());
    }

    @Test
    public void test3(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        System.out.println(String.join(",", list));
        //aa,bb,cc
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        StringJoiner joiner = new StringJoiner("','","'","'");
        list.forEach(t->joiner.add(t));
        System.out.println(joiner.toString());
        //'aa','bb','cc'
    }
}
