package com.rm13.base;

import java.util.ArrayList;

/**
 * 通过javap -c 反编译的方式 可以查看到增强行for循环使用的是迭代器方式实现循环
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/30
 */
public class ForEachTest {

    public static void main(String[] args) {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
