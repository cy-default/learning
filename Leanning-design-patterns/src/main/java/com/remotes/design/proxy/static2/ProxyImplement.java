package com.remotes.design.proxy.static2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class ProxyImplement implements InterfaceA {

    private InterfaceA interfaceA;

    public ProxyImplement() {
        this.interfaceA = new RealImplement();
    }

    @Override
    public void exec() {
        System.out.println("proxy before");
        //  实际调用
        interfaceA.exec();
        System.out.println("proxy after");
    }
}
