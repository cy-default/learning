package com.rm13.string;

/**
 * @Author: ChanFi
 * @Date: 2021/3/22 上午9:55
 */
public class StringFormatTest {

	public static void main(String[] args) {
		// 1.12；总位数不足前缀补空；
		System.out.println(String.format("%6.2f", 1.115555));
		// 1.11；总位数不足前缀补0；
		System.out.println(String.format("%06.2f", 1.114555));


	}
}
