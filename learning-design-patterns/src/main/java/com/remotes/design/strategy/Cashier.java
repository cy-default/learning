package com.remotes.design.strategy;

import java.math.BigDecimal;

/**
 * 策略上下文
 *
 * 采用组合的方式把会员集成进来。
 *
 * 多用组合，少用继承、针对接口编程，不针对实现编程两个设计原则。
 *
 * 收银台系统
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-14
 */
public class Cashier {

    /**
     * 会员, 策略对象
     */
    private Buyer buyer;

    public Cashier(Buyer buyer) {
        this.buyer = buyer;
    }

    /**
     * 报价
     * @param orderPrice
     * @return
     */
    public BigDecimal quote(BigDecimal orderPrice){
        return this.buyer.calPrice(orderPrice);
    }
}
