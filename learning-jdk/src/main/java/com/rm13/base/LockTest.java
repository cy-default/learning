package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/22
 */
public class LockTest {

    static{
        int a=0;
    }

    public synchronized void  lock(){
        int num=10;
    }

    public static void main(String[] args) {

        synchronized (LockTest.class){
            int a=10;
        }
    }
}
