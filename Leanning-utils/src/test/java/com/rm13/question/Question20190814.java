package com.rm13.question;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-15
 *
 * i<= end 永远成立。因为int最高位是符号位，再增加就变成负数。
 */
public class Question20190814 {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++){
            count++;
        }
        System.out.println(count);
    }
}
