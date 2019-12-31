package com.rm13.collection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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


        final long until = LocalDate.now().until(LocalDate.of(2019, 12, 25), ChronoUnit.DAYS);
        System.out.println(until);
    }
}
