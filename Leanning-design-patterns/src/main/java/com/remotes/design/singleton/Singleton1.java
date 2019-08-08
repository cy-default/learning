package com.remotes.design.singleton;

/**
 * 饿汉模式
 * 对象过早的实例化，浪费系统资源。
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-15
 */
public class Singleton1 {

    private static Singleton1 singleton = new Singleton1();

    public static Singleton1 getInstance(){
        return  singleton;
    }
}
