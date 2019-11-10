package com.rm13.springboot.mybatis.interceptor;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * <p>
 *    加解密接口实现
 * <p>
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-09 19:07
 */
@Component
public class EncryptDecryptImpl implements IEncryptDecrypt {
	@Override
	public <T> T encrypt(Field[] declaredFields, T parameterObject) throws IllegalAccessException {
		return EncryptDecryptUtils.encrypt(declaredFields, parameterObject);
	}

	@Override
	public <T> T decrypt(T result) throws IllegalAccessException {
		return EncryptDecryptUtils.decrypt(result);
	}
}
