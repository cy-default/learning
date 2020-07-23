package com.remotes.design.handler.demo1;

/**
 * 处理人，负责处理请假申请
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public abstract class LeaveHandler {

    /**
     * 直接后继， 用于传递请求
     */
    protected LeaveHandler successor;

    /**
     * 设置继任者
     * @param leaveHandler
     */
    public void setSuccessor(LeaveHandler leaveHandler){
        this.successor = leaveHandler;
    }

    /**
     * 处理请假申请
     * @param day
     */
    public abstract void disposeLeave(int day);
}
