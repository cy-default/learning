package com.rm13.algorithm.tmp;

import java.util.Arrays;
import java.util.List;

/**
 * 从集合中，查询比给定值大的，最小值；
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/12/4
 */
public class MinMaxNumMain {

    public static void main(String[] args) {
        int num = -1;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 24);
        num = minMaxNumber(list, 3);
        System.out.println(num);
        num = minMaxNumber(list, 17);
        System.out.println(num);
        num = minMaxNumber(list, 30);
        System.out.println(num);
    }

    private static int minMaxNumber(List<Integer> list, Integer compare) {
        for (Integer num : list) {
            if (num >= compare) {
                return num;
            }
        }
        return -1;
    }

}
