package com.remotes.design.handler.demo4;

/**
 * 设计模式之美：责任链模式第一种实现；基于链表的实现
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class Application {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());

        chain.handle();
    }
}
