package com.remotes.design.decorator2;

/**
 * 装饰器模式是继承的一种替代模式，其优点是可以动态扩展一个实现类的功能。
 * 这种设计模式下不仅可以扩展一个类的功能，也可以动态增加功能，动态撤销。
 * 但缺点就是多层装饰使用起来相对比较复杂。
 * 本质是将具体功能职责划分（例如区分核心组件以及附加属性职责）减少子类直接继承父类的耦合性。
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class HeroSkill implements Hero{

    /**
     * 提莫英雄
     */
    private Hero hero;

    public HeroSkill(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void leanSkill() {
        hero.leanSkill();
    }
}
