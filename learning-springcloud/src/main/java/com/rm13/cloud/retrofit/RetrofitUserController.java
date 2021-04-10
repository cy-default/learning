package com.rm13.cloud.retrofit;

import com.rm13.cloud.login.passlogin.PassLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenyuan
 * @Date: 2021/4/9 下午5:20
 */
@PassLogin
@Slf4j
@RestController
@RequestMapping("/retrofit/user")
public class RetrofitUserController {

	@GetMapping
	public List<RetrofitUser> getUser() {
		List<RetrofitUser> list = new ArrayList<>();
		list.add(new RetrofitUser(1, "张三"));
		list.add(new RetrofitUser(2, "李四"));
		return list;
	}

	@GetMapping("/{id}")
	public RetrofitUser getUserById(@PathVariable Integer id) {
		return new RetrofitUser(id, "法外狂徒张三");
	}

	@PostMapping
	public void add(@RequestBody RetrofitUser user) {
		log.info("将要新增的User: {}", user.toString());
	}

	@PutMapping("/{id}")
	public void update(@RequestBody RetrofitUser user, @PathVariable Integer id) {
		log.info("传入的用户信息：{}", user.toString());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		log.info("将要删除ID为{}的user", id);
	}

}