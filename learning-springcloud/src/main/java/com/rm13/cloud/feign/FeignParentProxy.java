package com.rm13.cloud.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Author: ChanFi
 * @Date: 2021/3/31 下午8:38
 */
public interface FeignParentProxy {

	@GetMapping(value = "/feign/parent")
	public String parent();
}
