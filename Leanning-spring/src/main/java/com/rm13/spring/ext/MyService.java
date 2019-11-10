package com.rm13.spring.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-10
 */
@Slf4j
@Service("myService")
public class MyService {

    @EventListener(classes={MyApplicationEvent.class})
    public void listen(MyApplicationEvent event){
        log.info("myService。。监听到的事件:{}", event);
    }
}
