package com.rm13.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/3
 */
public class ListSortTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        list.sort((o1, o2)->{
            return o1-o2;
        });

        System.out.println(list);
    }
}
