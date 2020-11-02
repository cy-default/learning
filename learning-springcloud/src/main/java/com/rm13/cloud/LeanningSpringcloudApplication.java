package com.rm13.cloud;

import com.rm13.cloud.factories.SecondApplicationContextInitializer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@EnableFeignClients
@EnableTransactionManagement
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, RabbitAutoConfiguration.class, MybatisAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class LeanningSpringcloudApplication {


    public static void main(String[] args) throws IOException {
        // final ConfigurableApplicationContext run = SpringApplication.run(LeanningSpringcloudApplication.class, args);
        SpringApplication springApplication = new SpringApplication(LeanningSpringcloudApplication.class);
        springApplication.addInitializers(new SecondApplicationContextInitializer());
        springApplication.run(args);

    }

}
