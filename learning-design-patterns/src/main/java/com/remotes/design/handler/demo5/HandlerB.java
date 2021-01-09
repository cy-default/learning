package com.remotes.design.handler.demo5;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class HandlerB extends Handler {
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        // ...
        System.out.println("HandlerB doHandle");
        return handled;
    }
}
