package com.rm13.base;

/**
 * @Author: ChanFi
 * @Date: 2021/3/3 上午9:29
 */
public class AAA<K,V> extends AA {

	public static void main(String[] args) {
		System.out.println(AAA.class.getGenericSuperclass().toString());
		System.out.println(AAA.class.getSuperclass().toString());
	}
}
