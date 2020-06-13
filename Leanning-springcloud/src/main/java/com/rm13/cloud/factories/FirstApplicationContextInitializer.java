package com.rm13.cloud.factories;

import com.google.common.collect.Maps;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

/**
 * spring容器刷新之前执行的一个回调函数，可以向容器中注册属性
 * Order(1) 可以来指定顺序
 *
 *
 * @see 'META-INF/spring.factories'
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/11
 */
@Order(1)
public class FirstApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("love", "lovemyrm13");
        MapPropertySource mapPropertySource = new MapPropertySource("FirstApplicationContextInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("======FirstApplicationContextInitializer======");

    }
}
