package com.rm13.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-25
 */
public class BaseStreamTest {

    public static void main(String[] args) {

        IntStream.rangeClosed(1,5).boxed().forEach(i-> System.out.println(i));
        System.out.println("===========");
        //list = new ArrayList<>();
        final List<Person> collect = list.stream().filter(t -> t.getSex().equals("1")).collect(Collectors.toList());
        System.out.println(collect.size());

        System.out.println(list.stream().distinct().collect(Collectors.toList()));


        //java8 效率低;把List集合中的对象分成每100条为一组
        List<Integer> lists = IntStream.rangeClosed(1, 101).boxed().collect(Collectors.toList());
        int subLength = 4;
        List<Integer> subLists = null;
        for (int i = 0; i < lists.size(); i+=subLength) {
            subLists = lists.stream().skip(i).limit(subLength).collect(Collectors.toList());
            System.out.println("java8:subLists:"+subLists.toString());
        }
        System.out.println("=====");
        // 把List集合中的对象分成每100条为一组
        for (int i = 0; i < lists.size(); i+=subLength) {
            subLists = lists.subList(i, Math.min(lists.size(), i+subLength));
            System.out.println("subLists:"+subLists.toString());
        }
    }

    private static List<Person> list  = null;

    static {
        /*
        Person wu = new Person("wu qi", 18,"男");
        Person zhang = new Person("zhang san", 19,"男");
        Person wang = new Person("wang si", 20,"女");
         */
        Person zhao1 = new Person("zhao wu", 20,"男");
        Person zhao2 = new Person("zhao wu", 19,"男");
        Person chen1 = new Person("chen liu", 21,"男");
        Person chen2 = new Person("chen liu", 22,"男");

        list = Arrays.asList(chen2, zhao2, zhao1, chen1);
    }
}
