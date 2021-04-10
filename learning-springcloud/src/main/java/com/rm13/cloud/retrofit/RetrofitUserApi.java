package com.rm13.cloud.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import okhttp3.OkHttpClient;
import retrofit2.http.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: chenyuan
 * @Date: 2021/4/9 下午4:45
 */
@RetrofitClient(baseUrl = "${api.user}")
public interface RetrofitUserApi {

	@OkHttpClientBuilder
	static OkHttpClient.Builder okhttpClientBuilder() {
		return new OkHttpClient.Builder()
				.connectTimeout(100000, TimeUnit.SECONDS)
				.readTimeout(100000, TimeUnit.SECONDS)
				.writeTimeout(100000, TimeUnit.SECONDS);

	}

	@GET("user")
	List<RetrofitUser> getUser();

	@GET("user/{id}")
	RetrofitUser getUserById(@Path("id")Integer id);

	@POST("user")
	Void addUser(@Body RetrofitUser user);

	@PUT("user/{id}")
	Void updateUser(@Body RetrofitUser user, @Path("id") Integer id);

	@DELETE("user/{id}")
	Void deleteUserById(@Path("id") Integer id);

}