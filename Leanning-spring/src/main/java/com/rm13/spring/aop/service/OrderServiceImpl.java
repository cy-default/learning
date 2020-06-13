package com.rm13.spring.aop.service;

import com.rm13.spring.aop.entity.AopOrder;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class OrderServiceImpl implements OrderService {

    private static AopOrder order = null;

    @Override
    public AopOrder createOrder(String username, String product) {
        order = new AopOrder();
        order.setUsername(username);
        order.setProduct(product);
        return order;
    }

    @Override
    public AopOrder queryOrder(String username) {
        return order;
    }
}
