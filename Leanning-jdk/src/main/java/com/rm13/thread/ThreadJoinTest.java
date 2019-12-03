package com.rm13.thread;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-03
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        System.out.println("ThreadJoinTest...main...before...");
        threadA.start();
        System.out.println("ThreadJoinTest...main...run...");
        threadA.join();
        System.out.println("ThreadJoinTest...main...join...");
        System.out.println("ThreadJoinTest...main...after...");
    }
}


class ThreadA extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadA...run...");
    }
}
