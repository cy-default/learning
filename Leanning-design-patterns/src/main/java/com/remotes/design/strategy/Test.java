package com.remotes.design.strategy;

import com.remotes.design.constant.Constants;
import java.math.BigDecimal;

/**
 * 策略模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-06-11
 */
public class Test {

    public static void main(String[] args) {

        String buyerType = Constants.Strategy.ParticularlyVipBuyer.getCode();
        strategy(buyerType);
    }


    public static double strategy(String buyerType) {
        // 创建上下文
        Cashier cashier = null;
        // 选择需要使用的策略对象
        Buyer strategy =  StrategyConfig.getInstance(buyerType);
        cashier = new Cashier(strategy);
        // 计算价格
        BigDecimal quote = cashier.quote(new BigDecimal(300));
        System.out.println(strategy.getType()+"会员商品的最终价格为:"+quote.doubleValue());
        return quote.doubleValue();
    }

    public static double strategy2() {
        // 选择并创建需要使用的策略对象
        Buyer strategy = new VipBuyer();
        // 创建上下文
        Cashier cashier = new Cashier(strategy);
        // 计算价格
        BigDecimal quote = cashier.quote(new BigDecimal(300));
        System.out.println("普通会员商品的最终价格为："+quote.doubleValue());

        strategy = new SuperVipBuyer();
        cashier = new Cashier(strategy);
        quote = cashier.quote(new BigDecimal(300));
        System.out.println("超级会员商品的最终价格为："+ quote.doubleValue());
        return quote.doubleValue();
    }
}
