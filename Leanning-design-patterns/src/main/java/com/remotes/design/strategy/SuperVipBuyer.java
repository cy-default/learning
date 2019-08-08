package com.remotes.design.strategy;

import com.remotes.design.constant.Constants;

import java.math.BigDecimal;

/**
 * 具体策略类
 *
 * 超级会员
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-13
 */
public class SuperVipBuyer implements Buyer {

    private final BigDecimal discount = new BigDecimal(0.7);


    @Override
    public String getType() {
        return Constants.Strategy.SuperVipBuyer.getCode();
    }

    /**
     * 超级会员折扣8折
     * @param orderPrice 订单价格
     * @return
     */
    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(discount);
    }
}
