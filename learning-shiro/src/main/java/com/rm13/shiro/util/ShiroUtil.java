package com.rm13.shiro.util;

import com.rm13.shiro.model.generator.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/24
 */
@Slf4j
public class ShiroUtil {

    /**
     * 获取当前登录者对象
     */
    public static User getPrincipal() {
        try {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            if (user != null) {
                return user;
            }
        } catch (UnavailableSecurityManagerException e) {
            log.error("ShiroUtil.getPrincipal error:{}", e.getMessage());
        } catch (InvalidSessionException e) {
            log.error("ShiroUtil.getPrincipal error:{}", e.getMessage());
        }
        return null;
    }
}
