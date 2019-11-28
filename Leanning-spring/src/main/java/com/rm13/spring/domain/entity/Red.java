package com.rm13.spring.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Getter
@Setter
@Component
public class Red implements BeanNameAware, ApplicationContextAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;
    private String name;

    public Red() {
        log.info("Red...constructor...");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

        String resolveStringValue = resolver.resolveStringValue("你好 ${os.name} 我是 #{20*18}");
        log.info("解析的字符串:{}",resolveStringValue);
    }
}
