package com.rm13.cloud.apiversion;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 当方法级别和类级别都有ApiVersion注解时，二者将进行合并（ApiVersionRequestCondition.combine）。
 * 最终将提取请求URL中版本号，与注解上定义的版本号进行比对，判断url是否符合版本要求。
 *
 * @Author: ChanFi
 * @Date: 2021/3/29 下午8:01
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

	private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile(".*v(\\d+).*");
	private int apiVersion;

	ApiVersionCondition(int apiVersion) {
		this.apiVersion = apiVersion;
	}

	private int getApiVersion() {
		return apiVersion;
	}

	@Override
	public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
		return new ApiVersionCondition(apiVersionCondition.getApiVersion());
	}

	@Override
	public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
		Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getRequestURI());
		if (m.find()) {
			Integer version = Integer.valueOf(m.group(1));
			if (version >= this.apiVersion) {
				return this;
			}
		}
		return null;
	}

	@Override
	public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
		return apiVersionCondition.getApiVersion() - this.apiVersion;
	}
}
