package com.rm13.base;

import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("20.2");
        bigDecimal = bigDecimal.add(new BigDecimal("20"));
        System.out.println(bigDecimal.toString());
    }
}
