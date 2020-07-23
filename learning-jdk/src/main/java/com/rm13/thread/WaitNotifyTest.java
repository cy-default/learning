package com.rm13.thread;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/19
 */
public class WaitNotifyTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable r1 = () -> {
            synchronized (WaitNotifyTest.class){
                System.out.println("r1 begin");
                try {
                    WaitNotifyTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("r1 end");
            }
        };
        Runnable r2 = () -> {
            synchronized (WaitNotifyTest.class){
                System.out.println("r2 begin");
                try {
                    WaitNotifyTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("r2 end");
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();


        Thread.sleep(3000);
        synchronized (WaitNotifyTest.class){
            WaitNotifyTest.class.notifyAll();
        }
        Thread.sleep(2000);

    }
}


