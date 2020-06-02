package com.rm13.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@EnableFeignClients
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class LeanningSpringcloudApplication {


    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext run = SpringApplication.run(LeanningSpringcloudApplication.class, args);
    }

}
