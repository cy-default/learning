package com.rm13.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/17
 */
@RestController
@RequestMapping("/amqp")
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/prd/base/{parm}")
    public String base(@PathVariable("parm") String parm) {
        final MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("count", 1);
        final Message message = new Message(parm.getBytes(), messageProperties);

        rabbitTemplate.send("snmt.test.exchange", "test.key", message);

        return parm;

    }

    @RequestMapping("/prd/dlx/{parm}")
    public String dlx(@PathVariable("parm") String parm) {
        final MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("count", 1);
        final Message message = new Message(parm.getBytes(), messageProperties);
        rabbitTemplate.send(RabbitConfig.dlxExchange, RabbitConfig.dlxKey, message);
        return parm;

    }
}
