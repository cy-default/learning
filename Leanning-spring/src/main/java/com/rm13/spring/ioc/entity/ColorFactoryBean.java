package com.rm13.spring.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        log.info("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是单例？
     * true：这个bean是单实例，在容器中保存一份
     * false：多实例，每次获取都会创建一个新的bean；
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
