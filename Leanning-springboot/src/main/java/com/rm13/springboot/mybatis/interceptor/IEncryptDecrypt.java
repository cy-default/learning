package com.rm13.springboot.mybatis.interceptor;

import java.lang.reflect.Field;

/**
 * <p>
 *    加解密接口, 可实现自定义方法定义加密解密规则
 * <p>
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-09 19:07
 */
public interface IEncryptDecrypt {

	/**
	 * 加密方法
	 *
	 * @param declaredFields  反射bean成员变量
	 * @param parameterObject Mybatis入参
	 * @param <T>
	 * @return
	 */
	public <T> T encrypt(Field[] declaredFields, T parameterObject) throws IllegalAccessException;


	/**
	 * 解密方法
	 *
	 * @param result Mybatis 返回值，需要判断是否是ArrayList类型
	 * @param <T>
	 * @return
	 */
	public <T> T decrypt(T result) throws IllegalAccessException;

}
