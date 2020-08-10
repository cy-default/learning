package com.rm13.spring.ioc.autowired;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/5
 */
@Service
public class OrderService implements Ordered {

    public OrderService() {
        System.out.println("OrderService");
    }

    @Override
    public int getOrder() {
        return 1000000;
    }
}
