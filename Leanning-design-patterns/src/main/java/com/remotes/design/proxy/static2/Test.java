package com.remotes.design.proxy.static2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class Test {
    public static void main(String[] args) {
        InterfaceA interfaceA = new ProxyImplement();
        interfaceA.exec();
    }
}
