package com.rm13.cloud.factories;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Order(2)
public class SecondApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("love", "lovemyrm14");
        MapPropertySource mapPropertySource = new MapPropertySource("SecondApplicationContextInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource);
        log.info("SecondApplicationContextInitializer initialize");

    }
}
