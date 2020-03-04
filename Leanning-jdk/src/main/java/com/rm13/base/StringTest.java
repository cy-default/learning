package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/6
 */
public class StringTest {

    public static void main(String[] args) {
        // utf-8编码下一个字符占3个字节
        String result = "好";
        System.out.println(result.getBytes().length);

        String s0 = "a";
        String s1="abc";
        String s2 = "a"+"b" +"c";
        String s3 = s0 +"bc";
    }
}
