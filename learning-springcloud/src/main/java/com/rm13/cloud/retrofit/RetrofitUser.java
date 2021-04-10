package com.rm13.cloud.retrofit;

import lombok.Data;

/**
 * @Author: chenyuan
 * @Date: 2021/4/9 下午5:21
 */
@Data
public class RetrofitUser {

	private Integer id;

	private String username;

	public RetrofitUser() {}

	public RetrofitUser(Integer id, String username) {
		this.id = id;
		this.username = username;
	}

}
