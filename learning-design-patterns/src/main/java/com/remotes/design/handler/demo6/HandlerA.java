package com.remotes.design.handler.demo6;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class HandlerA implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        // ...
        System.out.println("HandlerA handle");
        return handled;
    }
}
