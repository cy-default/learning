package com.rm13.spring.ioc.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/5
 */
@Service
public class UserService implements Ordered {

    @Autowired
    private OrderService orderService;

    public UserService() {
        System.out.println("UserService");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
