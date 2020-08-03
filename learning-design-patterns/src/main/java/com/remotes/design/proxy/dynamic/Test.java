package com.remotes.design.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true 生成代理对象类 Proxy$0
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //首先传入被代理类的类类型构建代理处理器
        CustomizeHandler handler = new CustomizeHandler(ISubjectImpl.class);
        //动态创建代理类。
        // 第一个参数为类加载器，
        // 第二个参数为代理类需要实现的接口列表，
        // 最后一个则是处理器。
        ISubject subject = (ISubject) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{ISubject.class}, handler);
        subject.exec();
    }
}
