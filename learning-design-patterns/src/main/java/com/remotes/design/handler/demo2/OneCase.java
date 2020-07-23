package com.remotes.design.handler.demo2;

/**
 * 第一个 责任链
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class OneCase extends BaseCase {

    public OneCase(boolean isConsume) {
        super(isConsume);
    }

    @Override
    protected void doSomething() {
        // TODO do something
        System.out.println(getClass().getName());
    }
}
