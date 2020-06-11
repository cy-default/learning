package com.rm13.spring.ioc;

import com.rm13.spring.ioc.config.MainConfigOfProfile;
import com.rm13.spring.ioc.entity.Yellow;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * IOC容器环境设置
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
public class IOCTestOfProfile {

    /**
     * 1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
     * 2、代码的方式激活某种环境；
     */
    @Test
    public void test01(){
        //1、创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : namesForType) {
            log.info("namesForType:{}", name);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        log.info("Yellow:{}", yellow);
        applicationContext.close();

    }

    @Test
    public void test02(){
        //1、创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : namesForType) {
            log.info("namesForType:{}", name);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        log.info("Yellow:{}", yellow);
        applicationContext.close();

    }
}
