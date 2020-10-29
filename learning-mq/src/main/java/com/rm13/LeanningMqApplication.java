package com.rm13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@SpringBootApplication(exclude = {RabbitAutoConfiguration.class})
public class LeanningMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeanningMqApplication.class, args);
    }

}
