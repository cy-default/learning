package com.remotes.design.proxy.dynamic;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class ISubjectImpl implements ISubject {
    @Override
    public void exec() {
        System.out.println("ISubjectImpl exec");
    }
}
