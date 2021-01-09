package com.remotes.design.handler.demo4;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handle();
}
