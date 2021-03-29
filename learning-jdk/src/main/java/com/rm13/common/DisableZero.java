package com.rm13.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 去掉小数点后面多余的0
 * @Author: ChanFi
 * @Date: 2021/3/9 上午11:40
 */
public class DisableZero {

	public static void main(String[] args) {
		BigDecimal value;
		BigDecimal noZeros;
		String result;

		System.out.println("=======");
		// 保留2位小数
		value = new BigDecimal("0.0000000000");
		value = value.setScale(2, RoundingMode.HALF_UP);
		result = value.toPlainString();
		System.out.println("result: " + result);
		// 去掉小数点后面多余的0
		value = new BigDecimal("0.0000000000");
		noZeros = value.stripTrailingZeros();
		result = noZeros.toPlainString();
		System.out.println("result: " + result);


	}
}
