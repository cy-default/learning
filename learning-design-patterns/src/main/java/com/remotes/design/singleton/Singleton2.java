package com.remotes.design.singleton;

/**
 * 懒汉模式
 * 双重检查模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-15
 */
public class Singleton2 {

    private static volatile Singleton2 singleton;

    public static Singleton2 getInstance(){
        if(singleton == null){
            synchronized (Singleton2.class){
                if(singleton == null){
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}
