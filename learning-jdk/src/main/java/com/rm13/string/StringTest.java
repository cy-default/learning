package com.rm13.string;

/**
 * @Author: ChanFi
 * @Date: 2021/3/13 下午5:52
 */
public class StringTest {

	public static void main(String[] args) {
		int num = 4;
		int code =21111;
		String format = String.format("%0" + num + "d", code);
		System.out.println(format);

		String tt = "123456";

		System.out.println(tt.substring(0,2));
		System.out.println(tt.substring(2,4));
	}
}
