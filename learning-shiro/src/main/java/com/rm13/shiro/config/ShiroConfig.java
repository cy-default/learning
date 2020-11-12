package com.rm13.shiro.config;

import com.rm13.shiro.config.customfilter.*;
import com.rm13.shiro.config.redis.CustomSessionManager;
import com.rm13.shiro.config.redis.RedisCacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/30
 */
@Configuration
public class ShiroConfig {

    /**
     * 自定义 认证/授权
     *
     * @return
     */
    @Bean
    public MyRealm myRealm() {
        // 配置Realm，需自己实现
        MyRealm myRealm = new MyRealm();
        // 默认没开启缓存
        // myRealm.setAuthenticationCachingEnabled(true);
        // 设置自定义规则的权限缓存逻辑
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    @Bean
    public SessionDAO customSessionDAO() {
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        return sessionDAO;
    }

    /**
     * session 会话管理
     *
     * @return
     */
    @Bean
    public CustomSessionManager sessionManager() {
        CustomSessionManager customSessionManager = new CustomSessionManager();
        customSessionManager.setSessionDAO(customSessionDAO());
        return customSessionManager;
    }

    /**
     * shiro 缓存管理（会话session， 认证authentication， 授权authorization， ）
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager shiroRedisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> shiroRedisTemplate = new RedisTemplate<>();
        shiroRedisTemplate.setKeySerializer(new GenericJackson2JsonRedisSerializer());
        shiroRedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        shiroRedisTemplate.setConnectionFactory(redisConnectionFactory);
        shiroRedisTemplate.afterPropertiesSet();
        return new RedisCacheManager(shiroRedisTemplate);
    }

    /**
     * shiro 核心管理器
     * 管理(authenticator, authorizer, sessionManager, realms, sessionDAO, cacheManager)
     *
     * @param redisCacheManager
     * @param myRealm
     * @param sessionManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(RedisCacheManager redisCacheManager,
                                           MyRealm myRealm,
                                           CustomSessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        securityManager.setCacheManager(redisCacheManager);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }


    /**
     * shiro 入口；
     * 先通过filter做第一层过滤，再通过注解做第二层拦截。（注解是通过Spring-aop来实现的）
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/shiro/logout", "logout");
        // 定义filterChain，静态资源不拦截
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        // druid数据源监控页面不拦截
        filterChainDefinitionMap.put("/druid/**", "anon");
        // 其余所有请求都要求登陆操作
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 重要地方，使用自定义的过滤器
        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put(DefaultFilter.user.name(), new ShiroUserFilter());
        filterMap.put(DefaultFilter.authc.name(), new ShiroFormAuthenticationFilter());
        filterMap.put(DefaultFilter.roles.name(), new ShiroRolesAuthorizationFilter());
        filterMap.put(DefaultFilter.perms.name(), new ShiroPermissionsAuthorizationFilter());
        filterMap.put(DefaultFilter.logout.name(), new ShiroLogoutFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(Sha1Hash.ALGORITHM_NAME);
        return hashedCredentialsMatcher;
    }

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * <p>
     * 相等于@EnableAspectJAutoProxy(proxyTargetClass=true)
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码;
     * ）
     * 可以扩展凭证匹配器，实现 输入密码错误次数后锁定等功能，下一次
     */
    /*
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(2);
        //storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
     */
}
