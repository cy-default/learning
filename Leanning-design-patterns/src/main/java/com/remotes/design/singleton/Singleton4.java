package com.remotes.design.singleton;

/**
 * 枚举方式
 * 用枚举方式实现单例模式，是目前比较推荐的。枚举方式的好处是：1、线程安全；2、防止反射出现多个实例；3、防止反序列化出现多个实例。
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-15
 */
public enum Singleton4 {

    INSTANCE;
    Singleton4(){}

    public Singleton4 getInstance() {
        return INSTANCE;
    }
}
