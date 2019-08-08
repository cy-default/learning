package com.remotes.design.proxy.static1;

/**
 * 张三买票
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-28
 */
public class ZhangSan implements BuyTicket {
    @Override
    public void buyTicket() {
        System.out.println("你好，我想买票");
    }

    @Override
    public void personData() {
        System.out.println("你好， 身份证号码是：xxxxxxxxx, 电话：13333333333");
    }
}
