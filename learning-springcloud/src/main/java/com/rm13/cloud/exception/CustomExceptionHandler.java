package com.rm13.cloud.exception;

import com.rm13.cloud.result.ResultResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * 拦截ServiceException
     *
     * @param ex ServiceException
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @Order(4)
    public ResultResponse handleException(ServiceException ex) {
        ResultResponse<Object> result = ResultResponse.error(ex.getCode(), ex.getMessage());
        // 日志已经记录异常了，不需要再把异常栈信息打印出来
        // 业务异常以 warn形式打印出来，系统异常以error形式打印
        logger.warn("CustomGlobalExceptionHandler ServiceException error", ex);
        // ex.printStackTrace();
        return result;
    }

    /**
     * 拦截spring validation exception
     *
     * @param ex BindException
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class, MissingServletRequestParameterException.class})
    @ResponseBody
    @Order(5)
    public ResultResponse handleValidationException(Exception ex) {
        ResultResponse<Object> result = new ResultResponse<>();
        BindingResult bindingResult = null;
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            bindingResult = e.getBindingResult();
        } else if (ex instanceof BindException) {
            BindException e = (BindException) ex;
            bindingResult = e.getBindingResult();
        }
        String message = null;
        if (bindingResult != null && bindingResult.getFieldError() != null) {
            FieldError fieldError = bindingResult.getFieldError();
            message = StringUtils.isBlank(fieldError.getDefaultMessage()) ? new ServiceException().matchMessage(
                    ExceptionDef.REQUIRED_PARAMS_NOT_EXISTS) : fieldError.getDefaultMessage();
        }
        result.setCode(ExceptionDef.REQUIRED_PARAMS_NOT_EXISTS);
        result.setMessage(message == null ? "请求必填参数为空" : message);
        result.setData(null);
        // 日志已经记录异常和异常栈信息了，不需要再把异常栈信息打印出来
        logger.error("CustomGlobalExceptionHandler BindException error", ex);
        // ex.printStackTrace();
        return result;
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    @Order(6)
    public ResultResponse<Object> handleException(HttpMediaTypeNotSupportedException ex) {
        ResultResponse<Object> result = new ResultResponse<>();
        result.setCode(ExceptionDef.C415);
        result.setMessage(new ServiceException().matchMessage(ExceptionDef.C415));
        result.setData(null);
        // 日志已经记录异常和异常栈信息了，不需要再把异常栈信息打印出来
        logger.error("CustomGlobalExceptionHandler HttpMediaTypeNotSupportedException error", ex);
        // ex.printStackTrace();
        return result;
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    @Order(7)
    public ResultResponse<Object> handleException(HttpRequestMethodNotSupportedException ex) {
        ResultResponse<Object> result = new ResultResponse<>();
        result.setCode(ExceptionDef.C405);
        result.setMessage(new ServiceException().matchMessage(ExceptionDef.C405));
        result.setData(null);
        // 日志已经记录异常和异常栈信息了，不需要再把异常栈信息打印出来
        logger.error("CustomGlobalExceptionHandler HttpRequestMethodNotSupportedException error", ex);
        // ex.printStackTrace();
        return result;
    }

    /**
     * 参数类型转换失败异常
     * @param ex
     * @return
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @Order(8)
    public ResultResponse<Object> handleException(MethodArgumentTypeMismatchException ex) {
        ResultResponse<Object> result = new ResultResponse<>();
        result.setCode(ExceptionDef.C500);
        result.setMessage(new ServiceException().matchMessage(ExceptionDef.C500));
        result.setData(null);
        // 日志已经记录异常和异常栈信息了，不需要再把异常栈信息打印出来
        logger.error("CustomGlobalExceptionHandler MethodArgumentTypeMismatchException error", ex);
        // ex.printStackTrace();
        return result;
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @Order(9)
    public ResultResponse<Object> handleException(Exception ex) {
        ResultResponse<Object> result = new ResultResponse<>();
        result.setCode(ExceptionDef.C500);
        result.setMessage(new ServiceException().matchMessage(ExceptionDef.C500));
        result.setData(null);
        // 日志已经记录异常和异常栈信息了，不需要再把异常栈信息打印出来
        logger.error("CustomGlobalExceptionHandler Exception error", ex);
        // ex.printStackTrace();
        return result;
    }
}