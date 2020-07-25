package com.rm13.gc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * G1垃圾回收器
 * <p> vm
 * -server -Xms10M -Xmx10M -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 * </p>
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/25
 */
public class CMSGCTest {


    public static void main(String[] args) {
        List<Byte> byteArryList = new ArrayList<Byte>();
        while (true) {
            Byte[] bytes = new Byte[1024 * 500];
            byteArryList.addAll(Arrays.asList(bytes));
        }

    }
}
