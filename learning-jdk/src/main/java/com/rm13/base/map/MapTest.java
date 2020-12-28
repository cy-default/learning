package com.rm13.base.map;

import java.util.HashMap;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/12/16
 */
public class MapTest {

    public static void main(String[] args) {
        System.out.println("-----compute----");
        System.out.println(compute("cc", 1));
        System.out.println(compute("love", 10));

        System.out.println("-----merge----");
        System.out.println(compute("cc", 1));
        System.out.println(compute("love", 10));

    }


    public static HashMap compute(String key, Integer value) {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("love", 1);
        map.compute(key, (k, v) -> v == null ? value : Math.max(v, value));
        return map;
    }

    public static HashMap merge(String key, Integer value) {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("love", 1);
        map.merge(key, value, (o, n) -> Math.max(o, n));
        return map;
    }
}
