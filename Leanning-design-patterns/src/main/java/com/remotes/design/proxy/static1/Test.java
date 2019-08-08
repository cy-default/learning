package com.remotes.design.proxy.static1;

/**
 * 静态代理模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class Test {

    public static void main(String[] args) {
        // 实例化代理类
        Scalpers proxy = new Scalpers(new ZhangSan());
        // 调用代理类的方法
        proxy.buyTicket();
    }
}
