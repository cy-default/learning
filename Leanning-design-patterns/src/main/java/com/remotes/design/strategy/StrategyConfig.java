package com.remotes.design.strategy;

import com.remotes.design.constant.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-14
 */
public class StrategyConfig {



    private static Map<String, Buyer> result ;

    static {
        result = new HashMap<>(3);
        Buyer buyer = new ParticularlyVipBuyer();
        result.put(Constants.Strategy.ParticularlyVipBuyer.getCode(), buyer);
        buyer = new SuperVipBuyer();
        result.put(Constants.Strategy.SuperVipBuyer.getCode(), buyer);
        buyer = new VipBuyer();
        result.put(Constants.Strategy.VipBuyer.getCode(), buyer);
    }


    /**
     * 通过指定的类型， 选择指定的策略
     * @param code
     * @return
     */
    public static Buyer getInstance(String code){
        Buyer buyer = null;
        buyer = result.get(code);
        if(buyer == null){
            buyer = result.get(Constants.Strategy.ParticularlyVipBuyer.getCode());
        }
        return buyer;
    }
}
