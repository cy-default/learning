package com.remotes.design.decorator.demo1;

/**
 * 定义奶茶的装饰类
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-10
 * 文章： https://www.jianshu.com/p/427342d3b5c0
 */
public abstract class DrinkMilkTeaMaterial implements DrinkMilkTea {

    /**
     * 将顶层接口以构造参数的方式传递进来
     */
    private DrinkMilkTea drinkMilkTea;

    public DrinkMilkTeaMaterial(DrinkMilkTea drinkMilkTea) {
        this.drinkMilkTea = drinkMilkTea;
    }

    /**
     * 重写顶层接口， 然后在这里调用接口里面的totalPrice()
     * @return
     */
    @Override
    public double totalPrice() {
        return drinkMilkTea.totalPrice();
    }

    /**
     * 重写顶层接口， 然后在这里调用接口里面的useMaterial()
     * @return
     */
    @Override
    public String useMaterial() {
        return drinkMilkTea.useMaterial();
    }
}
