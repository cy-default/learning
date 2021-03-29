package com.rm13.cloud.validate;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: ChanFi
 * @Date: 2021/3/26 下午4:56
 */
@Data
public class UserDTO {

	@Min(value = 10000000000000000L, groups = Update.class)
	private Long userId;

	@NotNull(groups = {Save.class, Update.class})
	@Length(min = 2, max = 10, groups = {Save.class, Update.class})
	private String userName;

	@NotNull(groups = {Save.class, Update.class})
	@Length(min = 6, max = 20, groups = {Save.class, Update.class})
	private String account;

	@NotNull(groups = {Save.class, Update.class})
	@Length(min = 6, max = 20, groups = {Save.class, Update.class})
	private String password;

	@NotNull(groups = {Save.class, Update.class})
	@Valid
	private Job job;

	@Data
	public static class Job {

		@Min(value = 1, groups = Update.class)
		private Long jobId;

		@NotNull(groups = {Save.class, Update.class})
		@Length(min = 2, max = 10, groups = {Save.class, Update.class})
		private String jobName;

		@NotNull(groups = {Save.class, Update.class})
		@Length(min = 2, max = 10, groups = {Save.class, Update.class})
		private String position;
	}

	/**
	 * 保存的时候校验分组
	 */
	public interface Save {
	}

	/**
	 * 更新的时候校验分组
	 */
	public interface Update {
	}
}
