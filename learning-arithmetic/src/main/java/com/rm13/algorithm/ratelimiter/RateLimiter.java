package com.rm13.algorithm.ratelimiter;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/31
 */
public interface RateLimiter {

    /**
     * 是否要限流
     * @return
     */
    boolean isOverLimit();

    /**
     * 当前QPS总数值（也就是窗口期内的访问总量）
     * @return
     */
    int currentQPS();

    /**
     * touch一下：增加一次访问量；
     * @return
     */
    boolean visit();

}
