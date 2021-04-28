package com.rm13.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: chenyuanValidation
 * @Date: 2021/4/19 下午5:07
 */
public class SubListTest {

	public static void main(String[] args) {
		int subLength = 10;
		List<Integer> lists = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		List<Integer> subLists = null;
		// 把List集合中的对象分成每100条为一组
		for (int i = 0; i < lists.size(); i+=subLength) {
			int min = Math.min(lists.size(), i + subLength);
			System.out.println("min:"+min);
			subLists = lists.subList(i, min);
			System.out.println("subLists:"+subLists.toString());
		}
	}

}
