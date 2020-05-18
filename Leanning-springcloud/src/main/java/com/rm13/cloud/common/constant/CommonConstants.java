package com.rm13.cloud.common.constant;

/**
 * 常量
 *
 * @author xiong.canwei
 * @version V1.0
 * @date 2020/2/18 20:14
 */
public final class CommonConstants {


    /**
     * Token过期时间 毫秒
     */
    public static final long TOKEN_EXPIRE_TIME = 30L * 60L * 1000L * 2 * 24;

    /**
     * Token属性名称
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * 前端密码加解密key
     */
    public static final String SECRET_KEY = "starhomestarhome";

    /**
     * 默认密码
     */
    public static final String DEFAULT_USER_LOGIN_KEY = "123456";

    /**
     * 图片验证码过期时间 毫秒
     */
    public static final long VERIFY_IMAGE_CODE_EXPIRE_TIME = 60000;

    /**
     * 手机短信证码过期时间  秒
     */
    public static final long MOBILE_CODE_EXPIRE_TIME = 60;

    /**
     * 逗号
     */
    public static final String COMMA = ",";

    /**
     * 资源信息
     */
    public static final String TOP_RESOURCE_CODE = "top_resource";

    public static final Integer SYNC_PAGE_SIZE = 500;

    public static final String FORMAT_LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_LOCAL_DATE = "yyyy-MM-dd";
}
