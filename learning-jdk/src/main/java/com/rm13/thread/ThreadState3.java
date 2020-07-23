package com.rm13.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-10-02
 */
public class ThreadState3 {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(()-> {
            LockSupport.park();
            while (true){
                Thread.yield();
            }
        });
        thread.start();
        Thread.sleep(50);
        System.out.println(thread.getState());
        LockSupport.unpark(thread);
        Thread.sleep(50);
        System.out.println(thread.getState());
    }
}
