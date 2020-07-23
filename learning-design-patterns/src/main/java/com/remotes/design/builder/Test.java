package com.remotes.design.builder;

/**
 * 建造者模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-04
 */
public class Test {
    public static void main(String[] args) {
         RateLimit.builder()
                 .limit(100L)
                 .type("RateLimt")
                 .build();
    }
}
