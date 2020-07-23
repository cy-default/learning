package com.remotes.design.strategy;

import com.remotes.design.constant.Constants;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

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
@Service
public class SuperVipBuyer implements Buyer, InitializingBean {

    // bigDecimal精度问题， 只能通过字符串构造函数解决， 其他类型的构造函数无法解决精度问题
    private final BigDecimal discount = new BigDecimal("0.7");


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

    @Override
    public void afterPropertiesSet() throws Exception {
        StrategyFactory.addStrategy( Constants.Strategy.SuperVipBuyer.getCode(), this);
    }
}
