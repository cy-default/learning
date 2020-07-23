package com.rm13.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/7
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            try{
                lock.lock();
                System.out.println("thread 1 before await");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 after await");
            }catch (Exception e){
                System.out.println("error");
            }finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(1000);
        lock.lock();

        try{
            Thread.sleep(2000);
            System.out.println("thread 2 before signal");
            condition.signal();
            System.out.println("thread 2 after signal");
        }catch (Exception e){
            System.out.println("error");
        }finally {
            lock.unlock();
        }

    }
}
