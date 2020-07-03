package com.rm13.aqs;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/2
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws IOException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        IntStream.range(0, 3).forEach(i->new Thread(() -> {
            System.out.println("beg:"+Thread.currentThread().getId());
            try {
                cyclicBarrier.await();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end:"+Thread.currentThread().getId());

        }).start());

        System.in.read();
    }
}
