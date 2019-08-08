package com.remotes.design.handler3;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class TwoCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {

        if("2".equals(input)){
            System.out.println(getClass().getName()+" do");
        }else{
            System.out.println(getClass().getName()+" undo");
            baseCase.doSomething(input, baseCase);
        }
    }
}
