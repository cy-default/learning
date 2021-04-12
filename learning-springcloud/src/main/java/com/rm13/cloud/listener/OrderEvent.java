package com.rm13.cloud.listener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 用户事件
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
@Getter
@Setter
public class OrderEvent extends ApplicationEvent {
    private String orderNo;
    private String orderPrice;

    public OrderEvent(Object source) {
        super(source);
    }

    public OrderEvent(Object source, String orderNo, String orderPrice) {
        super(source);
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
    }
}
