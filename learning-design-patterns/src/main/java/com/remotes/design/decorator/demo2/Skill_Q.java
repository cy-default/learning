package com.remotes.design.decorator.demo2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Skill_Q extends HeroSkill{

    /**
     * 技能名称
     */
    private String skillName;

    public Skill_Q(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void leanSkill() {
        System.out.println(" 学习了技能Q："+skillName);
        super.leanSkill();
    }
}
