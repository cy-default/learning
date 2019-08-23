package com.remotes.design.handler.demo3;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class DefaultCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
        System.out.println(getClass().getName()+" do");
    }
}
