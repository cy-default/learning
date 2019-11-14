package com.rm13.springboot.util;

import com.google.common.base.Preconditions;
import com.rm13.springboot.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

/**
 * guava Precondition参数校验 替代 if
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-14
 */
public class PreconditionUtil {

    /**
     * 判断字符串不能为空，若字符串为空则报异常
     *
     * @param validate
     *            待校验字符串
     * @param message
     *            标识字符串
     */
    public static void notEmpty(String validate, Integer code, String message) {
        try {
            Preconditions.checkState(!StringUtils.isEmpty(validate));
        } catch (Exception e) {
            throw new BusinessException(code, message);
        }

    }
}
