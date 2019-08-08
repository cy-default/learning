package com.remotes.design.handler;

/**
 * 项目经理可以批准一天的假期
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public class Lead extends LeaveHandler{

    @Override
    public void disposeLeave(int day) {
        if(day<=1){
            System.out.println("项目经理处理："+day+"天的假期");
        }else{
            if(successor!=null){
                // 如果他处理不了就向上传递请求
                successor.disposeLeave(day);
            }
        }
    }
}
