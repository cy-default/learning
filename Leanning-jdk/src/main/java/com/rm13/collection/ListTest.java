package com.rm13.collection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * ArrayList -> 数组 -> 数组是同一数据类型的集合
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-29
 */
public class ListTest {
    public static void main(String[] args) {
        Random random = new Random();
        int index = 0;
        List list = new ArrayList(16);
        list.add(11);
        list.add(22);

        list.add(1, 33);
        System.out.println(list);


        /*
         增强for循环反编译后的数据
         for(Iterator iterator = list.iterator(); iterator.hasNext();){
            o = iterator.next();
            System.out.println(o);
         }
         */
        for (Object o : list) {
            System.out.println(o);

        }

        /*
         增强for循环反编译后的数据
         for(Iterator iterator1 = linkedList.iterator(); iterator1.hasNext();){
            integer = (Integer)iterator1.next();
            System.out.println(integer)
         }
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(33);
        linkedList.add(44);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }


        final long until = LocalDate.now().until(LocalDate.of(2019, 12, 25), ChronoUnit.DAYS);
        System.out.println(until);
    }
}
