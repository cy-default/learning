package com.rm13.jvm;

import com.rm13.entity.InstanceUser;
import com.rm13.entity.StaticUser;

/**
 * 类的加载
 * 加载-》验证-》准备——》解析-》初始化-》使用-》卸载
 * 1：准备阶段： 先初始化类变量（默认赋值0/null/false）
 * 2：初始化阶段： 先初始化类变量的值，再初始化静态代码块，静态代码块执行顺序由上到下。
 * 3：初始化/实例化区别：初始化：类， 实例化：对象
 * 4：加载过程中，若依赖父类，则先加载父类
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-12
 */
public class ClassLoaderTest {

    static {
        System.out.println("ClassLoaderTest 静态代码块");
    }

    private static StaticUser staticUser  = new StaticUser();
    private InstanceUser instanceUser = new InstanceUser("张三", "上海");



    public static void main(String[] args) {
        System.out.println("main");
        final InstanceUser instanceUser = new ClassLoaderTest().instanceUser;
    }
}
