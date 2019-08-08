package com.remotes.design.handler3;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public interface BaseCase {
    /**
     * 所有case处理逻辑的方法
     * @param input
     * @param baseCase
     */
    void doSomething(String input, BaseCase baseCase);
}
