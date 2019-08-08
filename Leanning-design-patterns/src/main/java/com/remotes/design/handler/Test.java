package com.remotes.design.handler;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public class Test {

    private LeaveHandler handler;

    public LeaveHandler getHandler() {
        return handler;
    }

    public void setHandler(LeaveHandler handler) {
        this.handler = handler;
    }

    public void requestDiscount(int day){
        handler.disposeLeave(day);
    }

    public static void main(String[] args){
        Test test = new Test();
        test.setHandler(LeaveHandlerFactory.createHandler());
        test.requestDiscount(8);
    }
}
