package com.remotes.design.handler.demo3;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class CaseChainFactory {

    public static CaseChain caseChain(){
        CaseChain chain = new CaseChain();
        BaseCase one = new OneCase();
        BaseCase two = new TwoCase();
        BaseCase dft = new DefaultCase();
        chain.addBaseCase(one).addBaseCase(two).addBaseCase(dft);
        return chain;
    }
}
