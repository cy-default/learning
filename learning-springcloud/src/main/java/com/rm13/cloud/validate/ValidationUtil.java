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
	 *
	 *
	 * @param bean
	 * @param delimiter
	 * @return null:
	 */
	/**
	 * 验证
	 * @param bean    		bean
	 * @param delimiter 	错误分隔符
	 * @param group			验证分组，为空则默认分组；
	 * @param <T>
	 * @return				验证通过, 其他错误信息
	 */
	public static <T> String validate(T bean, String delimiter, Class group) {
		Set<ConstraintViolation<T>> validateSet = null;
		if (group == null) {
			validateSet = validator.validate(bean);
		} else {
			validateSet = validator.validate(bean, group);
		}
		if (CollectionUtils.isEmpty(validateSet)) {
			return null;
		} else {
			return validateSet.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(delimiter));
		}
	}
}

