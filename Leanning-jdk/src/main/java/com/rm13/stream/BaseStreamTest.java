package com.rm13.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-25
 */
public class BaseStreamTest {
    private static List<Person> list  = null;

    public static void main(String[] args) {

        //list = new ArrayList<>();
        final List<Person> collect = list.stream().filter(t -> t.getSex().equals("1")).collect(Collectors.toList());
        System.out.println(collect.size());

        System.out.println(list.stream().distinct().collect(Collectors.toList()));


    }

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
