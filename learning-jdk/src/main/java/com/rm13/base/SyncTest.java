package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/2
 */
public class SyncTest {

    public void test(){
        synchronized (this){
            int a=1;
        }
    }
}
