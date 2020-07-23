package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
public class TryCatchTest {
    static {
        System.out.println("static");
    }

    public static void main(String[] args) {
        int a =10;
        try{
            a=20;
        }catch (Exception e){
            a=30;
        }finally {
            a=40;
        }
    }
}
