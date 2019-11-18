package com.rm13.validate;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-18
 */
public class ValidateTest {

    public static void main(String[] args) {
        final boolean naN = Double.isNaN((Double) null);
        System.out.println(naN);
    }
}
