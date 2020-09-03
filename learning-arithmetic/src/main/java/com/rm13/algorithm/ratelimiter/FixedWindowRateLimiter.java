package com.rm13.algorithm.ratelimiter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定窗口算法限流器
 * 实现Runnable方法：是到下一个阶段（比如下一分钟时），重置初始值
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/31
 */
public class FixedWindowRateLimiter implements RateLimiter, Runnable {

    // 每秒最多容许方5哥请求
    private static final int DEFAULT_ALLOWED_VISIT_PER_SECOND = 5;

    private final int maxVisitPerSecond;

    // 当前已接受的总数
    private AtomicInteger count = new AtomicInteger(0);

    public FixedWindowRateLimiter() {
        this(DEFAULT_ALLOWED_VISIT_PER_SECOND);
    }

    public FixedWindowRateLimiter(int maxVisitPerSecond) {
        this.maxVisitPerSecond = maxVisitPerSecond;
    }

    @Override
    public boolean isOverLimit() {
        return currentQPS() >= maxVisitPerSecond;
    }

    @Override
    public int currentQPS() {
        return count.get();
    }

    /**
     * 访问一次，次数+1就完事 并且告知是否达到满格了
     *
     * @return
     */
    @Override
    public boolean visit() {
        count.incrementAndGet();
        return isOverLimit();
    }

    /**
     * 到了下一个窗口期，重置总访问量即可，非常简单
     */
    @Override
    public void run() {
        System.out.println("该窗口期的累计访问总量是：" + currentQPS() + "，进入下一个窗口期...");
        count.set(0);
    }


    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter rateLimiter = new FixedWindowRateLimiter();

        // 使用定时器：1s种表示一个窗口，固定的
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(rateLimiter, 1, 1, TimeUnit.SECONDS);

        // 此处我使用单线程访问，你可以改造成多线程版本
        while (true) {
            String currThreadName = Thread.currentThread().getName();
            boolean overLimit = rateLimiter.isOverLimit();
            if (overLimit) {
                System.out.printf("线程[%s]====被限流了====，因为访问次数已超过阈值[%s]\n", currThreadName, rateLimiter.currentQPS());
            } else {
                rateLimiter.visit();
                System.out.printf("线程[%s]访问成功，当前访问总数[%s]\n", currThreadName, rateLimiter.currentQPS());
            }

            Thread.sleep(100);
        }

    }
}

