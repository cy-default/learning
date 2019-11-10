package com.rm13.spring.ioc;

import com.rm13.spring.config.MainconfigOfExt;
import com.rm13.spring.config.MainconfigOfTx;
import com.rm13.spring.ext.MyApplicationEvent;
import com.rm13.spring.tx.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-10
 */
@Slf4j
public class IOCTestOfTx {

    @Test
    public void test() {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainconfigOfTx.class);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.insertUser();
        applicationContext.close();
    }
}