package com.rm13.spring.ioc.aop;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class MathCalculator {

    public MathCalculator() {
        System.out.println("constructor");
    }

    public int div(int i, int j){
        log.info("MathCalculator...div...");
        return i/j;
    }
}
