package com.remotes.design.decorator.demo2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Test {

    public static void main(String[] args) {
        Hero timor = new Timor("timor");
        HeroSkill heroSkill = new HeroSkill(timor);
        HeroSkill r = new Skill_R(heroSkill, "种蘑菇");
        HeroSkill e = new Skill_E(r,"毒性射击");
        HeroSkill w = new Skill_W(e, "小莫快跑");
        HeroSkill q = new Skill_Q(w, "致盲吹箭");
        //学习技能
        q.leanSkill();

    }
}
