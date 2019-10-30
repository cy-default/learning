package com.rm13.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList -> 数组 -> 数组是同一数据类型的集合
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-29
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(11);
        list.add("ssss");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }
    }
}
