package com.remotes.design.proxy.static2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class RealImplement implements InterfaceA {
    @Override
    public void exec() {
        System.out.println("real implement");
    }
}
