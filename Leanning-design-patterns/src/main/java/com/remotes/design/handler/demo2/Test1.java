package com.remotes.design.handler.demo2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class Test1 {

    public static void main(String[] args) {
        String input = "1";
        BaseCase oneCase = new OneCase("1".equals(input));
        BaseCase twoCase = new TwoCase("2".equals(input));
        BaseCase defaultCase = new DefaultCase(true);
        oneCase.setNextCase(twoCase);
        twoCase.setNextCase(defaultCase);

        oneCase.handleRequest();

    }
}
