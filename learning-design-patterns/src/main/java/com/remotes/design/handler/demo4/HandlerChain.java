package com.remotes.design.handler.demo4;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler){
        handler.setSuccessor(null);

        if(head==null){
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(){
        if(head!=null){
            head.handle();
        }
    }
}
