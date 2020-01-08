package com.rm13.test;

import sun.tools.attach.HotSpotVirtualMachine;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/7
 */
public class Test {
    public static void main(String[] args) {
        final Child child = new Child();
        child.say();
    }

}
