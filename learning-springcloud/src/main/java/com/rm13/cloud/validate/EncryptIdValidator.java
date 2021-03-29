package com.rm13.cloud.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义验证
 *
 * @Author: ChanFi
 * @Date: 2021/3/26 下午5:06
 */
public class EncryptIdValidator implements ConstraintValidator<EncryptId, String> {

	private static final Pattern PATTERN = Pattern.compile("^[a-f\\d]{32,256}$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// 不为null才进行校验
		if (value != null) {
			Matcher matcher = PATTERN.matcher(value);
			return matcher.find();
		}
		return true;
	}
}
