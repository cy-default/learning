package com.rm13.base;

import sun.net.www.ParseUtil;

import java.util.TreeMap;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/29
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1,1);
        map.put(10,10);
        map.put(20,20);
        map.put(15,15);
        map.put(11,11);

        System.out.println(map);

    }
}
