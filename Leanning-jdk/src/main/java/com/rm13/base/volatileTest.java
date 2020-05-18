package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/7
 */
public class volatileTest {

    private static volatile  int num = 10;

    public static void main(String[] args) {
        num++;
        System.out.println(num);
        synchronized (volatileTest.class){
            Demo demo = new Demo("11");

        }
    }
}

class Demo{

    private String cc;

    public Demo(String cc) {
        this.cc = cc;
    }
}
