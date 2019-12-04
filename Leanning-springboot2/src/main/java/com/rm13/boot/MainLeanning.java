package com.rm13.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-01
 */
@SpringBootApplication(scanBasePackages={"com.rm13.boot.leanning02"})
public class MainLeanning {

    public static void main(String[] args) {
        SpringApplication.run(MainLeanning.class, args);
    }
}
