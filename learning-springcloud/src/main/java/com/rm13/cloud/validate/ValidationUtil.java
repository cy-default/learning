package com.rm13.cloud.validate;

/**
 * @Author: chenyuan
 * @Date: 2021/4/6 上午10:07
 */

import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 验证工具类
 */
public class ValidationUtil {
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	/**
	 * 验证
	 * @param bean bean
	 * @param delimiter 错误分隔符
	 * @return null: 验证通过, 其他错误信息
	 */
	public static <T> String validate(T bean, String delimiter) {
		Set<ConstraintViolation<T>> validateSet = validator.validate(bean);
		if (CollectionUtils.isEmpty(validateSet)) {
			return null;
		} else {
			return validateSet.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(delimiter));
		}
	}
}

