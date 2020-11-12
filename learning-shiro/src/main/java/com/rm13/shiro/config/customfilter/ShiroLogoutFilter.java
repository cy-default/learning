package com.rm13.shiro.config.customfilter;

import com.alibaba.fastjson.JSON;
import com.rm13.shiro.common.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 处理基于配置路径的拦截
 * <p>
 * 重新onAccessDenied 实现shiro对未认证的页直接返回json 而不是重定向
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/11
 */
@Slf4j
public class ShiroLogoutFilter extends LogoutFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        log.info("ShiroLogoutFilter...");
        Subject subject = getSubject(request, response);
        try {
            subject.logout();
        } catch (SessionException ise) {
        }
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        ResponseMsg responseMsg = ResponseMsg.success("登出成功");
        // 返回自己的json
        out.write(JSON.toJSONString(responseMsg));
        out.flush();
        out.close();
        return false;
    }
}
