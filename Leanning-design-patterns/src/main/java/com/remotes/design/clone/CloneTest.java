package com.remotes.design.clone;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/24
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo before = new CloneDemo();
        before.setName("love");
        before.setAddrs(Arrays.asList(new Object()));

        CloneDemo after = (CloneDemo)before.clone();

        System.out.println(before);
        System.out.println(after);
        System.out.println(before.getAddrs());
        System.out.println(after.getAddrs());
    }
}
