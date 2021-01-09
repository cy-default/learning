package com.remotes.design.strategy;

import com.remotes.design.constant.Constants;
import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * 具体策略类
 *
 * 普通会员
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-13
 */
public class VipBuyer implements Buyer, InitializingBean {

    @Override
    public String getType() {
        return Constants.Strategy.VipBuyer.getCode();
    }

    /**
     * 如果用户的超级会员已经到期了，并且到期时间在一周内，那么就对用户的单笔订单按照超级会员进行折扣，
     * 并在收银台进行强提醒，引导用户再次开通会员，而且折扣只进行一次。
     *
     * 超级会员8折
     * 普通会员9折
     *
     * @param orderPrice 订单价格
     * @return
     */
    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        int superVipExpiredDays = getSuperVipExpiredDays();
        int superVipLeadDiscountTimes = getSuperVipLeadDiscountTimes();

        if(superVipExpiredDays < 7 && superVipLeadDiscountTimes < 1){
            return orderPrice.multiply(new BigDecimal(0.8));
        }
        return orderPrice.multiply(new BigDecimal(0.9));
    }


    /**
     * 获取过期会员领取超级会员折扣次数
     * @return
     */
    private int getSuperVipLeadDiscountTimes(){
        return 1;
    }

    /**
     * 获取超级会员到期时间
     * @return
     */
    private int getSuperVipExpiredDays(){
        return 1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StrategyFactory.addStrategy(getType(), this);
    }
}
