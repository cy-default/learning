package com.remotes.design.handler;

/**
 * 工厂模式创建责任链
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-24
 */
public class LeaveHandlerFactory {

    /**
     * 创建工厂方法
     * @return
     */
    public static LeaveHandler createHandler(){
        LeaveHandler lead = new Lead();
        LeaveHandler cto = new CTO();
        LeaveHandler hrBoss = new HrBoss();
        LeaveHandler ceo = new CEO();

        lead.setSuccessor(cto);
        cto.setSuccessor(hrBoss);
        hrBoss.setSuccessor(ceo);
        return lead;
    }
}
