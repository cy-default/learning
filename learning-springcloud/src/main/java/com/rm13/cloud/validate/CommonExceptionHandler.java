package com.rm13.cloud.validate;

import com.rm13.cloud.model.base.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 统一异常处理
 * @Author: ChanFi
 * @Date: 2021/3/26 下午4:56
 */
@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		StringBuilder sb = new StringBuilder("校验失败:");
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
		}
		String msg = sb.toString();
		return Result.error(50001, msg);
	}

	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Result handleConstraintViolationException(ConstraintViolationException ex) {
		return Result.error(50001, ex.getMessage());
	}
}
