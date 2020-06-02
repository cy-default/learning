package com.rm13.cloud.login;

import com.rm13.cloud.common.CustomException;
import com.rm13.cloud.pojo.dto.user.CurrentUser;
import org.springframework.core.NamedThreadLocal;

/**
 * 获取当前登陆用户
 */
public class LoginUserHolder {

    /**
     * C端用户账号信息本地变量
     */
    private static final ThreadLocal<CurrentUser> C_ACCOUNT_THREAD_LOCAL = new NamedThreadLocal<>("C_ACCOUNT_THREAD_LOCAL");

    public static void set(CurrentUser currentUser) {
        C_ACCOUNT_THREAD_LOCAL.set(currentUser);
    }

    public static void remove() {
        C_ACCOUNT_THREAD_LOCAL.remove();
    }

    public static CurrentUser get() {
        CurrentUser userInfo = C_ACCOUNT_THREAD_LOCAL.get();
        if (userInfo == null) {
            throw new CustomException(1102,"用户不存在");
        }
        return userInfo;
    }
    private LoginUserHolder() {
    }
}
