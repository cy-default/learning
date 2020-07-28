package com.rm13.aqs;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过多线程DEBUG的方式 查看ReentrantLock 的lock/unlock
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/28
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws IOException {

        final ReentrantLock reentrantLock = new ReentrantLock();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            reentrantLock.lock();
            System.out.println("Thread-->" + Thread.currentThread().getId());
            reentrantLock.unlock();
        });

        executorService.submit(() -> {
            reentrantLock.lock();
            System.out.println("Thread-->" + Thread.currentThread().getId());
            reentrantLock.unlock();
        });

        System.in.read();

    }
}
