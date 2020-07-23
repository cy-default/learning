package com.rm13.cloud.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 用户事件
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
public class OrderEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
    }
}
