package com.remotes.design.decorator.demo2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Skill_R extends HeroSkill{

    /**
     * 技能名称
     */
    private String skillName;

    public Skill_R(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void leanSkill() {
        System.out.println(" 学习了技能R："+skillName);
        super.leanSkill();
    }
}
