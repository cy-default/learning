package com.remotes.design.strategy;

import com.remotes.design.constant.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuan.chen
 * @email yuan.chen@ingeek.com
 * @company INGEEK
 * @Date 2019-05-14
 */
public class StrategyFactory {



    private static Map<String, Buyer> result = new ConcurrentHashMap<>(3);

    private StrategyFactory(){

    }

    public static void addStrategy(String type, Buyer buyer){
        result.put(type, buyer);
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
