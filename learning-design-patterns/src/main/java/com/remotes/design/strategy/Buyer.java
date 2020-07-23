package com.remotes.design.strategy;

import java.math.BigDecimal;

/**
 * 策略接口
 *
 * 购买者/用户
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-13
 */
public interface Buyer {

    /**
     * 获取类别
     * @return
     */
    public String getType();

    /**
     * 计算应付价格
     * @param orderPrice 订单价格
     * @return
     */
    public BigDecimal calPrice(BigDecimal orderPrice);


}
