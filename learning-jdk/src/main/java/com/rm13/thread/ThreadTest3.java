package com.rm13.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/2
 */
public class ThreadTest3 {

    static AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {

        Print p1 = new Print();
        Print p2 = new Print();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        p1.setT(t2);
        p2.setT(t1);
        t1.start();
        t2.start();
        LockSupport.unpark(t1);
    }

    static class Print implements Runnable {
        private volatile Thread t;

        @Override
        public void run() {
            while (num.get()<100) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " : " + num.getAndIncrement());
                LockSupport.unpark(t);
            }
        }

        public void setT(Thread t) {
            this.t = t;
        }
    }
}

