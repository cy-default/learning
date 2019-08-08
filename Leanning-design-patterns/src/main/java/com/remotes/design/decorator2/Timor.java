package com.remotes.design.decorator2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Timor implements Hero {

    private String name;

    public Timor(String name) {
        this.name = name;
    }

    @Override
    public void leanSkill() {
        System.out.println(name + " 学习了以上技能");
    }
}
