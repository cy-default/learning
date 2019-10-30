package com.rm13.algorithm.lru;

/**
 * 数组实现LRU
 * 1： 若数组中存在该元素
 *  1.1: 把存在的元素放到arr[0]
 * 2： 若数组中不存在该元素
 *  2.1: 若数组容量已满，把数组值后移一位，arr[0]加入新元素
 *  2.2: 若数组容量未满，
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-29
 */
public class LRUArray {

    private static final Integer DEFAULT_CAPACITY = 5;
    private Integer capacity;

    private Integer count;

    private int[] arr;

    public LRUArray(){
        capacity = DEFAULT_CAPACITY;
        arr = new int[capacity];
    }
}
