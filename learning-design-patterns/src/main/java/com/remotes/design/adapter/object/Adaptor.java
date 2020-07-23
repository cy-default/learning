package com.remotes.design.adapter.object;

import com.remotes.design.adapter.Adaptee;
import com.remotes.design.adapter.ITarget;

/**
 * 对象适配器: 基于组合
 * <p>
 * 如果 Adaptee 接口很多，
 * 而且 Adaptee 和 ITarget 接口定义大部分都不相同，
 * 那我们推荐使用对象适配器，因为组合结构相对于继承更加灵活。
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/24
 */
public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        //委托给Adaptee
        adaptee.fa();
    }

    @Override
    public void f2() {
        //...重新实现f2()...
    }

    @Override
    public void fc() {
        //委托给Adaptee
        adaptee.fc();
    }
}
