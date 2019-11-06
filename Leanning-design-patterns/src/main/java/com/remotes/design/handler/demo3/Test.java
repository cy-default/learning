package com.remotes.design.handler.demo3;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class Test {
    public static void main(String[] args) {
        String input = "1";
        CaseChain chain = CaseChainFactory.caseChain();
        System.out.println("==first==");
        chain.doSomething(input, chain);
        chain.reset();
        System.out.println("==second==");
        chain.doSomething(input, chain);
    }
}
