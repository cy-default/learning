package com.rm13.cloud;

import com.rm13.cloud.bean.HelloBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@EnableFeignClients
@SpringBootApplication
public class LeanningSpringcloudApplication {


    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext run = SpringApplication.run(LeanningSpringcloudApplication.class, args);
        final HelloBean bean = run.getBean(HelloBean.class);
        bean.getHello();
    }

}
