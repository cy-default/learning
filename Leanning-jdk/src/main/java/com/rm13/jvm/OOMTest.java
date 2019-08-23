package com.rm13.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-22
 */
public class OOMTest {

    private static List<Byte[]> result = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        while (true){
            // 10k
            Byte[] bt = new Byte[1024*10];
            result.add(bt);
            Thread.sleep(50);
        }
    }
}
