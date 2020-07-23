package com.remotes.design.decorator.demo1;

/**
 * 布丁奶茶， 使用了布丁材料
 * 布丁装饰类
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-10
 */
public class Pudding extends DrinkMilkTeaMaterial {


    public Pudding(DrinkMilkTea drinkMilkTea) {
        super(drinkMilkTea);
    }

    /**
     * 在父类的价格基础上+2
     * @return
     */
    @Override
    public double totalPrice() {
        return super.totalPrice() + 2;
    }

    /**
     * 在父类的材料基础上+布丁
     * @return
     */
    @Override
    public String useMaterial() {
        return super.useMaterial()+" 添加了： 布丁 ";
    }
}
