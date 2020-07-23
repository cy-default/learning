package com.rm13.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/20
 */
public class EnhanceForTest {

    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5};
        for (Integer i : a) {
            System.out.println(i);
        }

        List<Integer> aa = Arrays.asList(1,2,3,4);
        for (Integer integer : aa) {
            System.out.println(integer);
        }
    }
}
