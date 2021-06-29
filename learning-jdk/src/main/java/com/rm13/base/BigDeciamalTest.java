package com.rm13.base;

import java.math.BigDecimal;

/**
 * @Author: chenyuan
 * @Date: 2021/4/22 下午3:54
 */
public class BigDeciamalTest {

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("123423111.211232131220000000");
		System.out.println(bigDecimal.stripTrailingZeros().toPlainString());
		BigDecimal demo1 = new BigDecimal("0.0000");
		System.out.println(demo1.toPlainString());

	}
}
