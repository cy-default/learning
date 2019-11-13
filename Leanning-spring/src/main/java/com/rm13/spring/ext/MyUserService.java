package com.rm13.spring.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-13
 */
@Slf4j
@Service
public class MyUserService {

    @EventListener(classes={MyApplicationEvent.class})
    public void listen(MyApplicationEvent event){
        log.info("MyUserService...listen:{}", event);
    }
}
