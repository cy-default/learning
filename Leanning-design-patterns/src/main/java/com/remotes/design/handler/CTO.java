package com.remotes.design.handler;

/**
 * CTO可以批准三天的假期
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public class CTO extends LeaveHandler {
    @Override
    public void disposeLeave(int day) {
        if(day<=3){
            System.out.println("CTO可以处理："+day+"天内的假期");
        }else{
            if(successor!=null){
                // 如果他处理不了就向上传递请求
                successor.disposeLeave(day);
            }
        }
    }
}
