package com.rm13.cloud.listener;

import com.rm13.cloud.pojo.po.Order;
import com.rm13.cloud.pojo.po.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
@Service
public class OrderService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;


    public String order(String orderNo, User currentUser){
        final Order order = new Order();
        order.setGoodsId(1L);
        order.setOrderNo(UUID.randomUUID().toString().replaceAll("-",""));
        order.setUserId(1L);
        // 支付成功

        // 发布下单事件 1：物流发货。2：增加积分
        applicationEventPublisher.publishEvent(new OrderEvent(order));
        return order.getOrderNo();
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
