package com.remotes.design.handler.demo2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public abstract class BaseCase {

    /**
     * 为true表明自己可以处理该case
     */
    private boolean isConsume;

    /**
     * 下一个责任节点
     */
    private BaseCase nextCase;

    public BaseCase(boolean isConsume){
        this.isConsume = isConsume;
    }

    public void setNextCase(BaseCase nextCase){
        this.nextCase = nextCase;
    }


    /**
     * 责任链请求
     */
    public void handleRequest(){
        if(isConsume){
            // 如果当前节点可以处理， 直接处理
            doSomething();
        }else{
            // 如果当前节点不能处理，并且有下一个节点，交由下一个节点处理
            if(nextCase != null){
                nextCase.handleRequest();
            }
        }
    }

    abstract protected void doSomething();

}
