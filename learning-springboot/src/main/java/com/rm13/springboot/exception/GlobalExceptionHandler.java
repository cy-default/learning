package com.rm13.springboot.exception;

import com.rm13.springboot.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 统一异常处理
 * <p>
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07 17:38
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 认证异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AuthenticationException.class)
    public ResultResponse authenticationException(AuthenticationException e) {
        log.error("AuthenticationException:{}", e.getMessage());
        return ResultResponse.error(403, e.getMessage());
    }

    /**
     * 自定义业务异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public ResultResponse businessException(BusinessException e) {
        log.error("BusinessException:{}", e.getMessage());
        return ResultResponse.error(500, e.getMessage());
    }

    /**
     * 自定义系统异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SystemException.class)
    public ResultResponse systemException(SystemException e) {
        log.error("BusinessException:{}", e.getMessage());
        return ResultResponse.error(-1, e.getMessage());
    }

    /**
     * 全局异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultResponse globalException(Exception e) {
        e.printStackTrace();
        return ResultResponse.error(-1, e.getMessage());
    }


}
