package com.remotes.design.decorator.demo1;

/**
 * 青稞奶茶， 使用了青稞材料
 * 青稞装饰类
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-10
 */
public class HighlandBarley extends DrinkMilkTeaMaterial {

    public HighlandBarley(DrinkMilkTea drinkMilkTea) {
        super(drinkMilkTea);
    }

    /**
     * 在父类的价格基础上+3
     * @return
     */
    @Override
    public double totalPrice() {
        return super.totalPrice() + 3;
    }

    /**
     * 在父类的材料基础上+青稞
     * @return
     */
    @Override
    public String useMaterial() {
        return super.useMaterial() + " 添加了： 青稞 ";
    }
}
