package com.rm13.thread;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/2
 */
public class ThreadTest4 {

    private static int num = 1;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    if ((num & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + "-" + num++);
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (num < 100) {
                synchronized (lock) {
                    if ((num & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + "-" + num++);
                    }
                }
            }
        }).start();
    }
}

