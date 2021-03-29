package com.rm13.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: ChanFi
 * @Date: 2021/3/5 下午8:45
 */
public class ParallelStream {

	public static void main(String[] args) {
		List result = new ArrayList<Integer>();
		IntStream.rangeClosed(1, 100).forEach(t -> result.add(t));

		result.parallelStream().forEach(t -> {
			System.out.println(Thread.currentThread().getName() + "-------" + t);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("result");
	}
}
