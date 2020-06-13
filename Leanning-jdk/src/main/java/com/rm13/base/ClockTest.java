package com.rm13.base;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/21
 */
public class ClockTest {
    public static void main(String[] args) {
        final TimeZone aDefault = TimeZone.getDefault();
        System.out.println(ZoneId.systemDefault());
        System.out.println(aDefault);

        System.out.println(System.currentTimeMillis());
    }
}
