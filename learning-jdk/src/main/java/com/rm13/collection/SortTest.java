package com.rm13.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/14
 */
public class SortTest {

    public static void main(String[] args) {
        final List<Long> strings = Arrays.asList(1L);

        Collections.sort(strings, (o1, o2) -> (int)(o1-o2));
        System.out.println(strings);
    }
}
