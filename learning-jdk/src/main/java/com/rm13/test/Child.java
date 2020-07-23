package com.rm13.test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/7
 */
public class Child extends Parent{

    public Child() {
        System.out.println("Child...");
    }

    // 复写了父类的方法，不会再调用父类
    @Override
    public void say() {
        System.out.println("Child...say...");
    }
}
