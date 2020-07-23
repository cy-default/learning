package com.rm13.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/6
 */
@Slf4j
public class ThreadPoolTest {


    public static void main(String[] args) throws IOException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        printStats(threadPoolExecutor);


        IntStream.rangeClosed(1, 20).forEach(__ -> threadPoolExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                TimeUnit.SECONDS.sleep(30);
                System.out.println("=====");
            }
        }));

        System.in.read();
    }


    /**
     * 需要定时打印线程池信息
     *
     * @param threadPool
     */
    private static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 5, TimeUnit.SECONDS);
    }
}
