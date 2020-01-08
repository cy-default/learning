package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/6
 */
public class IntegerTest02 {

    public static void main(String[] args) {
        Integer num = 10;
        System.out.println(Integer.reverse(num));

        System.out.println(Integer.toHexString(num));
        System.out.println(Integer.decode("0xa"));


        Integer a1 = 10000;
        Integer a2 = 10000;
        Byte b1=127;
        Byte b2 = 127;
        System.out.println(b1==b2);
        System.out.println(a1==a2);
    }
}
