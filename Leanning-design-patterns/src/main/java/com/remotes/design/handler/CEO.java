package com.remotes.design.handler;

/**
 * 老板，只要他同意，你可以无限期休假
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public class CEO extends LeaveHandler {
    @Override
    public void disposeLeave(int day) {
        //因为这里所有的假期他都可以处理所以没有判断
        System.out.println("CEO处理："+day+"天的假期");
    }
}
