package com.remotes.design.proxy.dynamic;

import org.apache.ibatis.annotations.AutomapConstructor;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class ISubjectImpl implements ISubject {


    @Override
    public void exec() {
        System.out.println("ISubjectImpl exec");
        exec2();
    }

    @Override
    public void exec2() {
        System.out.println("ISubjectImpl exec2");
    }
}
