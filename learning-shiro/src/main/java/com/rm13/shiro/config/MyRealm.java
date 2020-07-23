package com.rm13.shiro.config;

import com.alibaba.fastjson.JSON;
import com.rm13.shiro.mapper.dao.ResourceDao;
import com.rm13.shiro.mapper.dao.UserDao;
import com.rm13.shiro.model.bo.UserBO;
import com.rm13.shiro.model.generator.Resource;
import com.rm13.shiro.model.generator.User;
import com.rm13.shiro.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.message.config.AuthConfig;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    /**
     * static final constant value
     */
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;

    @javax.annotation.Resource
    private UserDao userDao;
    @javax.annotation.Resource
    private ResourceDao resourceDao;


    /**
     * 登陆认证
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        log.info("doGetAuthenticationInfo:{}", token.getUsername());
        // 通过用户名到数据库查询用户信息
        final User user = userDao.selectByUserName(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        // 第二个参数要是数据库中的用户密码， 通过HashedCredentialsMatcher来校验输入的用户密码和数据库中的用户密码是否匹配
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        return info;
    }

    /**
     * 用户鉴权，如AuthorizingRealm未配置Cache，每次请求都会调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        final User user = (User) principals.getPrimaryPrincipal();
        log.info("MyRealm.doGetAuthorizationInfo:{}", JSON.toJSONString(user));
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        final List<Resource> resources = resourceDao.selectResourceByUserName(user.getUsername());
        final Set<String> collect = resources.stream().map(l -> l.getPermCode()).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(collect);
        return simpleAuthorizationInfo;
    }
}
