package com.remotes.design.decorator2;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Skill_W extends HeroSkill{

    /**
     * 技能名称
     */
    private String skillName;

    public Skill_W(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void leanSkill() {
        System.out.println(" 学习了技能W："+skillName);
        super.leanSkill();
    }
}
