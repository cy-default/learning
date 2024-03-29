package com.rm13.cloud.validate;

import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 集合校验
 * @Author: ChanFi
 * @Date: 2021/3/26 下午4:41
 */
public class ValidationList<E> implements List<E> {

	@Delegate // @Delegate是lombok注解
	@Valid // 一定要加@Valid注解
	public List<E> list = new ArrayList<>();

	// 一定要记得重写toString方法
	@Override
	public String toString() {
		return list.toString();
	}
}