package com.remotes.design.handler.demo1;

/**
 * Hr人事老大，可以批准一个星期内的假期
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public class HrBoss extends LeaveHandler {
    @Override
    public void disposeLeave(int day) {
        if(day<=5){
            System.out.println("HR老大处理："+day+"天内的假期");
        }else{
            if(successor!=null){
                // 如果他处理不了就向上传递请求
                successor.disposeLeave(day);
            }
        }
    }
}
