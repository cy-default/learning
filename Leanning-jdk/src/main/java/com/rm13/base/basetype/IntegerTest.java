package com.rm13.base.basetype;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-02
 */
public class IntegerTest {

    public static void main(String[] args) {
        // 整数转16进制
        toHex();
    }

    public static void toHex(){
        Integer num = 10;
        System.out.println(Integer.toHexString(num));
    }
}
