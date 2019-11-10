package com.rm13.springboot.mybatis.interceptor;

import com.rm13.springboot.mybatis.interceptor.annotation.EncryptDecryptField;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <p>
 *    Domain数据加密工具类
 * <p>
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-09 19:07
 */
public class EncryptDecryptUtils {


	/**
	 * 多field加密方法
	 *
	 * @param declaredFields
	 * @param parameterObject
	 * @param <T>
	 * @return
	 * @throws IllegalAccessException
	 */
	public static <T> T encrypt(Field[] declaredFields, T parameterObject) throws IllegalAccessException {
		for (Field field : declaredFields) {
			EncryptDecryptField annotation = field.getAnnotation(EncryptDecryptField.class);
			if (Objects.isNull(annotation)) {
				continue;
			}
			encrypt(field, parameterObject);
		}
		return parameterObject;
	}


	/**
	 * 单个field加密方法
	 *
	 * @param field
	 * @param parameterObject
	 * @param <T>
	 * @return
	 * @throws IllegalAccessException
	 */
	public static <T> T encrypt(Field field, T parameterObject) throws IllegalAccessException {
		field.setAccessible(true);
		Object object = field.get(parameterObject);

		if (object instanceof BigDecimal) {
			//TODO 定制BigDecimal类型的加密算法
		} else if (object instanceof Integer) {
			//TODO 定制Integer类型的加密算法
		} else if (object instanceof Long) {
			//TODO 定制Long类型的加密算法
		} else if (object instanceof String) {
			//TODO 定制String类型的加密算法
			String encode = AESUtil.aesEncode((String)object);
			field.set(parameterObject, encode);
		}
		return parameterObject;
	}

	/**
	 * 解密方法
	 *
	 * @param result
	 * @param <T>
	 * @return
	 * @throws IllegalAccessException
	 */
	public static <T> T decrypt(T result) throws IllegalAccessException {
		Class<?> parameterObjectClass = result.getClass();
		Field[] declaredFields = parameterObjectClass.getDeclaredFields();
		decrypt(declaredFields, result);
		return result;
	}

	/**
	 * 多个field解密方法
	 *
	 * @param declaredFields
	 * @param result
	 * @throws IllegalAccessException
	 */
	public static void decrypt(Field[] declaredFields, Object result) throws IllegalAccessException {
		for (Field field : declaredFields) {
			EncryptDecryptField annotation = field.getAnnotation(EncryptDecryptField.class);
			if (Objects.isNull(annotation)) {
				continue;
			}
			decrypt(field, result);
		}
	}

	/**
	 * 单个field解密方法
	 *
	 * @param field
	 * @param result
	 * @throws IllegalAccessException
	 */
	public static void decrypt(Field field, Object result) throws IllegalAccessException {
		field.setAccessible(true);
		Object object = field.get(result);
		if (object instanceof BigDecimal) {
			//TODO 定制BigDecimal类型的加密算法
		} else if (object instanceof Integer) {
			//TODO 定制Integer类型的加密算法
		} else if (object instanceof Long) {
			//TODO 定制Long类型的加密算法
		} else if (object instanceof String) {
			//TODO 定制String类型的加密算法
			String encode = AESUtil.aesDecode((String)object);
			field.set(result, encode);
		}
	}


}
