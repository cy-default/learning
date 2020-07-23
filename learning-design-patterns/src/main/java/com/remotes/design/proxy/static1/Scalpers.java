package com.remotes.design.proxy.static1;

/**
 * 黄牛
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class Scalpers implements BuyTicket {

    private BuyTicket buyTicket;

    public Scalpers(BuyTicket buyTicket) {
        this.buyTicket = buyTicket;
    }

    @Override
    public void buyTicket() {
        buyTicket.buyTicket();
        System.out.println("黄牛：购买车票请提供你的信息");
        System.out.println("----信息准备中----");
        buyTicket.personData();
        System.out.println("黄牛：乘车人信息已收到， 我帮你刷票，记得五星好评");
    }

    @Override
    public void personData() {
        buyTicket.personData();
    }
}
