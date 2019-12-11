package com.rm13.springboot.util;

import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-10
 */
public final class AmountUtil {

    public static final BigDecimal HUNDRED = new BigDecimal(100);

    private AmountUtil() {
    }

    public static String changeF2Y(Long amount) {
        return amount == null ? "" : BigDecimal.valueOf(amount).divide(HUNDRED).toString();
    }

    public static Long changeY2F(String amount) {
        return (new BigDecimal(amount)).multiply(HUNDRED).setScale(0, 4).longValue();
    }
}
