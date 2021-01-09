package com.remotes.design.handler.demo5;

/**
 * 使用模版方法来规避每个实现的处理器重复编写继任者处理逻辑
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/9
 */
public abstract class Handler {
    private Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle(){
        boolean handled = doHandle();
        // 若想让所有处理链都处理；则屏蔽handled判断逻辑；
        if(successor!=null && !handled){
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}
