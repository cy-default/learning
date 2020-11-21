package com.rm13.amqp;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/17
 */
@Slf4j
@Component
public class RabbitMQConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // bindings 和 queues 互斥
    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(value = RabbitConfig.testExchange, type = ExchangeTypes.DIRECT, durable = "true", autoDelete = "false"),
                    value = @Queue(value = RabbitConfig.testQueue, durable = "true", autoDelete = "false"),
                    key = RabbitConfig.testKey
            ),
            // errorHandler = "myRabbitListenerErrorHandler",
            concurrency = "5"
    )
    public void recive1(Channel channel, Message message, @Payload String payload) throws IOException {
        log.info("recive1:{},{}", JSON.toJSONString(message), payload);

        // Integer count = (Integer) message.getMessageProperties().getHeaders().get("count");
        // count++;
        // message.getMessageProperties().getHeaders().put("count", count);
        // 把消息发送到死信队列中
        rabbitTemplate.send(RabbitConfig.dlxExchange, RabbitConfig.dlxKey, message);


        // int a = 1 / 0;

        // 普通队列确认消费该消息
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    // @RabbitListener(queues = "snmt.test.queue", errorHandler = "myRabbitListenerErrorHandler", concurrency = "5")
    public void recive2(Channel channel, Message message, @Payload String payload) throws IOException {
        log.info("recive2:{},{}", new String(message.getBody()), payload);
        Integer count = (Integer) message.getMessageProperties().getHeaders().get("count");
        System.out.println(count);
        count++;
        message.getMessageProperties().getHeaders().put("count", count);
        System.out.println(message);
        // 把消息发送到死信队列中
        rabbitTemplate.send(RabbitConfig.dlxExchange, RabbitConfig.dlxKey, message);
        // int a = 1 / 0;
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }
}
