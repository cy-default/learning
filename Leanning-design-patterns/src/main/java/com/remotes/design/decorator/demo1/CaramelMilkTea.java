package com.remotes.design.decorator.demo1;

/**
 * 焦糖奶茶， 本质就是核心组件（布丁， 奶霜， 青稞必须附加这些组件才有价值）
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-10
 */
public class CaramelMilkTea implements DrinkMilkTea {

    /**
     *
     * @return
     */
    @Override
    public double totalPrice() {
        return 12;
    }

    @Override
    public String useMaterial() {
        return "焦糖奶茶";
    }
}
