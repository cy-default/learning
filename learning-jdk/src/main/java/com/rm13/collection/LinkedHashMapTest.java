package com.rm13.collection;

import java.util.LinkedHashMap;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/17
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap(10, 0.75f, true);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map);
        System.out.println(map.get(2));
        System.out.println(map);
    }
}
