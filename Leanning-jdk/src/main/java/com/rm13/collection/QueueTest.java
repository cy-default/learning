package com.rm13.collection;

import java.util.LinkedList;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/1
 */
public class QueueTest {

    private String a;
    private static final QueueTest q1;

    private static final QueueTest q2 = new QueueTest("q2");

    private static final QueueTest q3;
    static {
        q3 = new QueueTest("q3");
    }

    static {
        q1 = new QueueTest("q1");
    }

    public QueueTest(String a) {
        System.out.println("cons==>"+a);
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(11);

    }
}
