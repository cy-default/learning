package com.rm13.cloud.common;

import com.rm13.cloud.domain.dto.user.UserDTO;
import org.springframework.core.NamedThreadLocal;

/**
 * 获取当前登陆用户
 */
public class LoginUserHolder {

    /**
     * C端用户账号信息本地变量
     */
    private static final ThreadLocal<UserDTO> C_ACCOUNT_THREAD_LOCAL = new NamedThreadLocal<>("C_ACCOUNT_THREAD_LOCAL");

    public static void set(UserDTO userDTO) {
        C_ACCOUNT_THREAD_LOCAL.set(userDTO);
    }

    public static void remove() {
        C_ACCOUNT_THREAD_LOCAL.remove();
    }

    public static UserDTO get() {
        UserDTO userInfo = C_ACCOUNT_THREAD_LOCAL.get();
        if (userInfo == null) {
            throw new CustomException("用户不存在");
        }
        return userInfo;
    }
    private LoginUserHolder() {
    }
}
