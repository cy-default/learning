package com.remotes.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class CustomizeHandler implements InvocationHandler {
    private Object target;

    /**
     * 其中构造方法传入被代理类的类类型。
     * 其实传代理类的实例或者是类类型并没有强制的规定，
     * 传类类型的是因为被代理对象应当由代理创建而不应该由调用方创建。
     * @param clazz
     */
    public CustomizeHandler(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        System.out.println("proxy class:"+proxy.getClass().getName());
        return result;
    }

    private void before(){
        System.out.println("before");
    }


    private void after(){
        System.out.println("after");
    }
}
