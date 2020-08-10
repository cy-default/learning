package com.rm13.spring.ioc.autowired;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/5
 */
@Component
public class OrderListener implements ApplicationListener, Ordered {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("OrderListener");
    }

    @Override
    public int getOrder() {
        return 10000;
    }
}
