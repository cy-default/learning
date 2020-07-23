package com.rm13.base;

import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/14
 */
public class BoxingUnboxingTest {

    public static void main(String[] args) {
        int num = 10;;
        Thread.currentThread();
        Thread.yield();
        Integer num2 = num;

        System.out.println(null==null);

        BigDecimal m = new BigDecimal("1.255533");
        BigDecimal n = m.setScale(3,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(n);// 1.255

    }
}
