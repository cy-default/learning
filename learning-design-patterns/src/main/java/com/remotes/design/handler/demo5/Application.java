package com.remotes.design.handler.demo5;

/**
 * 设计模式之美：责任链模式第一种实现优化；基于链表的实现
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class Application {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addhandler(new HandlerA());
        chain.addhandler(new HandlerB());
        chain.addhandler(new HandlerA());
        chain.addhandler(new HandlerA());

        chain.handle();
    }
}
