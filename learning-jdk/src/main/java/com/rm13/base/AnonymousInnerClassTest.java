package com.rm13.base;

import java.util.ArrayList;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/14
 */
public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        final ArrayList arrayList = new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
            }
        };
        System.out.println(arrayList.size());
    }
}
