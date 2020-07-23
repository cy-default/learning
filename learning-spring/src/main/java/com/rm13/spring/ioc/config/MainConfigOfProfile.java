package com.rm13.spring.ioc.config;

import com.rm13.spring.ioc.entity.Yellow;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

/**
 * Profile：
 * 		Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 *
 * 开发环境、测试环境、生产环境；
 * 数据源：(/A)(/B)(/C)；
 *
 *
 * @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在，任何环境下都是加载的；
 */
@Configuration
@PropertySource(value = {"classpath:dbConfig.properties"})
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    private StringValueResolver valueResolver;

    private String driveClass;

    @Value("${db.user}")
    private String user;



    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public HikariDataSource testDataSource(@Value("db.password")String password) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc.mysql://localhost:3306/demo");
        hikariDataSource.setDriverClassName(driveClass);
        hikariDataSource.setUsername(user);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public HikariDataSource devDataSource(@Value("db.password")String password) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc.mysql://localhost:3306/demo");
        hikariDataSource.setDriverClassName(driveClass);
        hikariDataSource.setUsername(user);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public HikariDataSource prodDataSource(@Value("db.password")String password) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc.mysql://localhost:3306/demo");
        hikariDataSource.setDriverClassName(driveClass);
        hikariDataSource.setUsername(user);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driveClass = valueResolver.resolveStringValue("${db.driverClass}");
    }

}
