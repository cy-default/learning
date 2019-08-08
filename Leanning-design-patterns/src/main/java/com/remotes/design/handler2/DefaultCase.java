package com.remotes.design.handler2;
/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class DefaultCase extends BaseCase {

    public DefaultCase(boolean isConsume) {
        super(isConsume);
    }

    @Override
    protected void doSomething() {
        // TODO do something
        System.out.println(getClass().getName());
    }
}
