package com.rm13.cloud.common.constant;

/**
 * Redis Key
 *
 * @author xiong.canwei
 * @version V1.0
 * @date 2020/2/19 20:14
 */
public final class RedisConstants {

    /**
     * 前缀
     */
    public static final String SYSTEM_KEY_PREFIX = "HRPRO:";

    /**
     * 管理平台登陆用户信息
     */
    public static final String LOGIN_USER_INFO = SYSTEM_KEY_PREFIX + "USER:INFO:E:";

    /**
     * 验证码
     */
    public static final String VERIFY_IMAGE_CODE = SYSTEM_KEY_PREFIX + "VERIFYIMAGE:";

    public static final String LOCK_KEY = SYSTEM_KEY_PREFIX + "LOCK:";

    public static final int LOCK_KEY_EXPIRE_MSECS = 1000 * 30;

}
