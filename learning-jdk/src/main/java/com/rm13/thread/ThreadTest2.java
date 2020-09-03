package com.rm13.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/2
 */
public class ThreadTest2 implements Runnable {
    AtomicInteger num = new AtomicInteger(1);
    @Override
    public void run() {
        while(num.get()<=100){
            synchronized (num){
                num.notifyAll();
                System.out.println(Thread.currentThread().getName()+"--"+num.get());
                num.incrementAndGet();
                try {
                    num.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadTest2 threadTest2 = new ThreadTest2();
        final Thread thread1 = new Thread(threadTest2);
        final Thread thread2 = new Thread(threadTest2);
        thread1.start();
        thread2.start();

        Thread.sleep(100000);

    }
}
