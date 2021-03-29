package com.rm13.cloud.apiversion;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Author: ChanFi
 * @Date: 2021/3/29 下午8:11
 */
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {

	@Override
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		return new ApiRequestMappingHandlerMapping();
	}
}
