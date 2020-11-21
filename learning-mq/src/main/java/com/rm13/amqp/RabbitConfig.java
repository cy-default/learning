package com.rm13.amqp;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * * @EnableRabbit 该注解非必须，默认已经有了
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/17
 */
// @EnableRabbit
@Configuration
public class RabbitConfig {

    // 普通消息队列
    public static final String testExchange = "test.exchange";
    public static final String testQueue = "test.queue";
    public static final String testKey = "test.key";

    // dlx死信队列
    public static final String dlxExchange = "dlx.exchange";
    public static final String dlxQueue = "dlx.queue";
    public static final String dlxKey = "dlx.key";


    @Bean
    public MyRabbitListenerErrorHandler myRabbitListenerErrorHandler() {
        return new MyRabbitListenerErrorHandler();
    }

    @Bean("dlxQueue")
    public Queue dlxQueue() {
        return QueueBuilder.durable(RabbitConfig.dlxQueue)
                //
                .withArgument("x-dead-letter-exchange", RabbitConfig.testExchange)
                // dead letter携带的routing key
                .withArgument("x-dead-letter-routing-key", RabbitConfig.testKey)
                //
                .withArgument("x-message-ttl", 10 * 1000)
                .build();
    }

    @Bean("dlxExchange")
    public Exchange dlxExchange() {
        return ExchangeBuilder.directExchange(RabbitConfig.dlxExchange)
                .build();
    }

    @Bean("dlxBinding")
    public Binding dlxBinding() {
        return BindingBuilder.bind(dlxQueue())
                .to(dlxExchange())
                .with(RabbitConfig.dlxKey)
                .noargs();
    }

}
