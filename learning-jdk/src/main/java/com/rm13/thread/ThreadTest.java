package com.rm13.thread;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-16
 */
public class ThreadTest implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest());
        thread.start();
        System.out.println("111");
        thread.interrupt();
        thread.isInterrupted();
        System.out.println("222");

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":1");
        int num =100000000;
        while(num>0){
            num--;
        }
        System.out.println(Thread.currentThread().getName()+":2");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+":3");

        }
    }
}
