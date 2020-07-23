package com.remotes.design.decorator.demo1;

/**
 * 装饰器模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-10
 */
public class Test {

    public static void main(String[] args) {
        //实例化一个焦糖奶茶
        DrinkMilkTea drinkMilkTea = new CaramelMilkTea();
        System.out.println(drinkMilkTea.useMaterial() + " 总价："+drinkMilkTea.totalPrice());

        //添加布丁
        drinkMilkTea = new Pudding(drinkMilkTea);
        System.out.println(drinkMilkTea.useMaterial() + " 总价："+drinkMilkTea.totalPrice());

        //添加青稞
        drinkMilkTea = new HighlandBarley(drinkMilkTea);
        System.out.println(drinkMilkTea.useMaterial() + " 总价："+drinkMilkTea.totalPrice());

        //添加第二份青稞
        drinkMilkTea = new HighlandBarley(drinkMilkTea);
        System.out.println(drinkMilkTea.useMaterial() + " 总价："+drinkMilkTea.totalPrice());

    }
}
