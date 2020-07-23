package com.rm13.base;

import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1");
        bigDecimal = bigDecimal.add(new BigDecimal("1"));
        System.out.println(bigDecimal.toString());



        BigDecimal a1 = new BigDecimal("1");
        BigDecimal a2 = new BigDecimal("3");

        System.out.println(a1.divide(a2, 1, BigDecimal.ROUND_DOWN));

    }
}
