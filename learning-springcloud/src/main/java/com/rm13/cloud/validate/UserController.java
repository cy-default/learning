package com.rm13.cloud.validate;

import com.rm13.cloud.model.base.Result;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * 类注解上的validated必须要加，否则form-data/get请求等无法验证
 *
 * @Author: ChanFi
 * @Date: 2021/3/26 下午4:54
 */
@RequestMapping("/api/user")
@RestController
@Validated
public class UserController {

	// 路径变量
	@GetMapping("{userId}")
	public Result detail(@PathVariable("userId") @Min(10000000000000000L) Long userId) {
		// 校验通过，才会执行业务逻辑处理
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setAccount("11111111111111111");
		userDTO.setUserName("xixi");
		userDTO.setAccount("11111111111111111");
		return Result.success(userDTO);
	}

	// 查询参数
	@GetMapping("getByAccount")
	public Result getByAccount(@Length(min = 6, max = 20) @NotNull String account) {
		// 校验通过，才会执行业务逻辑处理
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(10000000000000003L);
		userDTO.setAccount(account);
		userDTO.setUserName("xixi");
		userDTO.setAccount("11111111111111111");
		return Result.success(userDTO);
	}

	/**
	 * 嵌套校验、分组验证
	 *
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/save")
	public Result saveUser(@RequestBody @Validated(UserDTO.Save.class) UserDTO userDTO) {
		// 校验通过，才会执行业务逻辑处理
		return Result.success();
	}

	/**
	 * 嵌套校验、分组验证
	 *
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/update")
	public Result updateUser(@RequestBody @Validated(UserDTO.Update.class) UserDTO userDTO) {
		// 校验通过，才会执行业务逻辑处理
		return Result.success();
	}

	/**
	 * 集合校验
	 *
	 * @param userList
	 * @return
	 */
	@PostMapping("/saveList")
	public Result saveList(@RequestBody @Validated(UserDTO.Save.class) ValidationList<UserDTO> userList) {
		// 校验通过，才会执行业务逻辑处理
		return Result.success();
	}


	@Autowired
	private javax.validation.Validator globalValidator;

	/**
	 * 编程式校验
	 *
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/saveWithCodingValidate")
	public Result saveWithCodingValidate(@RequestBody UserDTO userDTO) {
		Set<ConstraintViolation<UserDTO>> validate = globalValidator.validate(userDTO, UserDTO.Save.class);
		// 如果校验通过，validate为空；否则，validate包含未校验通过项
		if (validate.isEmpty()) {
			// 校验通过，才会执行业务逻辑处理

		} else {
			for (ConstraintViolation<UserDTO> userDTOConstraintViolation : validate) {
				// 校验失败，做其它逻辑
				System.out.println(userDTOConstraintViolation);
			}
		}
		return Result.success();
	}
}
