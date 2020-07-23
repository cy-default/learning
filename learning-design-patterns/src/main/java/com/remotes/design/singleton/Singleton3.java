package com.remotes.design.singleton;

/**
 * 静态内部类实现(懒汉模式)
 * 当调用ggetInstance()才会触发加载静态内部类，从而初始化获取instance实例。利用静态内部类的加载机制来保证线程安全。
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-15
 */
public class Singleton3 {

    public static class SingletonInstance{
        private static final Singleton3 singleton = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonInstance.singleton;
    }
}
