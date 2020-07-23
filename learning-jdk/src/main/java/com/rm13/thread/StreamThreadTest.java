package com.rm13.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/7
 */
public class StreamThreadTest {

    public static void main(String[] args) {
        // Stream 并行流处理，采用的线程池是 公用的ForkJoinPool。默认线程数是 CPU - 1
        final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        IntStream.rangeClosed(1, 100).parallel().forEach(__ -> map.put(Thread.currentThread().getName(), Thread.currentThread()));

        System.out.println(map.size());
        System.out.println(map.keySet());
    }
}
