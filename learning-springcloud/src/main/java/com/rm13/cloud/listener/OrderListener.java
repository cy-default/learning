package com.rm13.cloud.listener;

import com.alibaba.fastjson.JSON;
import com.rm13.cloud.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器， 监听指定事件
 * 1: 默认采用的是同步的方式执行, 为了保证顺序需要对同步执行的代码排序@Order
 * 2: 若需要采用异步的方式执行, 则可以使用@Async注解实现异步。
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
@Slf4j
@Component
@Order(1)
public class OrderListener implements ApplicationListener<OrderEvent> {

    @Async(value = "rm13TaskExecutor")
    @Override
    public void onApplicationEvent(OrderEvent event) {
        Object source = event.getSource();
        if (source instanceof User) {
            log.info("UserListener:{}", JSON.toJSON(source));
        }
    }
}
