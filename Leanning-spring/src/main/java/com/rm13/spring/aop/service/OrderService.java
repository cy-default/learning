package com.rm13.spring.aop.service;

import com.rm13.spring.aop.entity.AopOrder;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public interface OrderService {

    AopOrder createOrder(String username, String product);

    AopOrder queryOrder(String username);
}
