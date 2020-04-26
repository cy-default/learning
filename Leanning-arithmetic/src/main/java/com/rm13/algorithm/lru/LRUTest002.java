package com.rm13.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/15
 */
public class LRUTest002 {

    public static void main(String[] args) {
        Lru<Integer, Integer> lru = new Lru<>(5);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        System.out.println(lru);
        System.out.println(lru.get(2));
        System.out.println(lru);
    }
}


class Lru<K, V> extends LinkedHashMap<K, V>{

    private int capacity;

    public Lru(int initialCapacity) {
        super(initialCapacity, 0.75f,true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>this.capacity;
    }
}