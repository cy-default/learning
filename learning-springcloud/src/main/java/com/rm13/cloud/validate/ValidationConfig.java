package com.rm13.cloud.validate;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 快速失败
 * <p>
 * Spring Validation默认会校验完所有字段，然后才抛出异常;
 *
 * @Author: ChanFi
 * @Date: 2021/3/26 下午5:11
 */
@Configuration
public class ValidationConfig {

	/**
	 * Spring Validation默认会校验完所有字段，然后才抛出异常。
	 * 可以通过一些简单的配置，开启Fali Fast模式，一旦校验失败就立即返回。
	 * @return
	 */
	@Bean
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
				.configure()
				// 快速失败模式
				.failFast(true)
				.buildValidatorFactory();
		return validatorFactory.getValidator();
	}
}
