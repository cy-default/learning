package com.rm13.base;

import java.util.Objects;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-29
 */
public class IntegerTest {
    public static void main(String[] args) {
        // 自动装箱的时候调用valueof 方法
        //  Integer num1 = Integer.valueOf(1); valueof 默认缓存 -128到127的Integer包装类对象
        Integer num1 = 201;
        Integer num4 = 201;
        System.out.println(num1==num4);
        System.out.println("++++");
        int num2 = 1;
        Integer num3 = new Integer(1);

        // num1.intValue() == num2
        System.out.println(num1==num2);

        // 不同对象， false
        System.out.println(num1==num3);

        // -Djava.lang.Integer.IntegerCache.high=100 指定IntegerCache的缓存值大小
        System.out.println(sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high"));

        System.out.println(null == null);

        System.out.println(Objects.deepEquals(null, null));
    }
}
