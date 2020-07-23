package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/22
 */
public class InstructTest {
    public static void main(String[] args) {


    }

    public static void test1() {
        int i = 0;
        i = ++i + i++ + i++ + i++;
        System.out.println("i=" + i);
    }

    public static int test2() {
        int x = 0;
        try {
            return x;
        } finally {
            ++x;
        }
    }

}
