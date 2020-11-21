package com.rm13.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/18
 */
public class MyRabbitListenerErrorHandler implements RabbitListenerErrorHandler {
    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {

        System.out.println("MyRabbitListenerErrorHandler");

        return null;
    }
}
