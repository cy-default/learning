package com.rm13.cloud.retrofit;

import com.rm13.cloud.LeanningSpringcloudApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: chenyuan
 * @Date: 2021/4/9 下午5:48
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeanningSpringcloudApplication.class)
class UserApiTest {

	@Autowired
	private RetrofitUserApi userApi;
	@Autowired
	private RetrofitUserController retrofitUserController;

	@Test
	void testGetUser() {
		List<RetrofitUser> user1 = retrofitUserController.getUser();
		List<RetrofitUser> user = userApi.getUser();
		log.info("得到的用户信息： {}", user);
	}

	@Test
	void testGetUserById() {
		RetrofitUser user = userApi.getUserById(1);
		log.info("得到的用户信息： {}", user);
	}

	@Test
	void testAddUser() {
		userApi.addUser(new RetrofitUser(null, "没有名字"));
	}

	@Test
	void testUpdateUser() {
		userApi.updateUser(new RetrofitUser(1, "柴米油盐酱醋茶"), 1);
	}

	@Test
	void testDeleteUser() {
		userApi.deleteUserById(1);
	}

}
