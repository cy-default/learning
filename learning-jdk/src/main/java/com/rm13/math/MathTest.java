package com.rm13.math;

/**
 * @Author: chenyuan
 * @Date: 2021/4/2 下午6:13
 */
public class MathTest {

	public static void main(String[] args) {
		System.out.println((int)Math.ceil(1.00002 * 2));

		Integer integer = Integer.valueOf("000001");
		System.out.println(integer);

		String result = "12345";

		String substring = result.substring(2, 4);
		System.out.println(substring);
	}
}
