package com.remotes.design.handler3;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class OneCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {

        if("1".equals(input)){
            System.out.println(getClass().getName()+" do");
            return;
        }else{
            System.out.println(getClass().getName()+" undo");
            baseCase.doSomething(input, baseCase);
        }
    }
}
