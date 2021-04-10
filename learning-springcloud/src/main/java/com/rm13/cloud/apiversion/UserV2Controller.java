package com.rm13.cloud.apiversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ChanFi
 * @Date: 2021/3/29 下午8:26
 */
//@RequestMapping("api/{version}/user")
//@RestController
//@ApiVersion(2)
public class UserV2Controller {
	@GetMapping("/test")
	public String test() {
		return "user v2 test";
	}
}
