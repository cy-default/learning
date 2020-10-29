package com.rm13.cloud.login;

import com.rm13.cloud.model.dto.user.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Method;

/**
 * 需要把该类加入到webmvc参数解析中
 *
 * @see com.rm13.cloud.login.LoginConfig
 * @see com.rm13.cloud.login.LoginController
 * 登陆用户 参数解析器
 * <p>
 * 自动注入当前登陆用户
 * </p>
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 用于判断当前参数是否需要转换类型
     *
     * @param parameter 源参数
     * @return {@code true} 参数类型为 {@link CurrentUser}
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        final Method method = parameter.getMethod();
        if (method != null) {
            return parameter.getParameterType().isAssignableFrom(CurrentUser.class);
        }
        return false;
    }

    /**
     * 参数转换
     *
     * @param parameter     源参数
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return LoginUserHolder.get();
    }
}
