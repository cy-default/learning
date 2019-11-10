package com.rm13.spring.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-10
 */
@Slf4j
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    /**
     * 当容器发布此事件后， 方法触发
     * @param event
     */
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        log.info("收到事件:{}", event);
    }
}
