package com.rm13.boot.leanning02.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-04
 */
@Configuration
@EnableConfigurationProperties({PersonProperties.class})
public class PropertiesConfiguration {

    @Autowired
    PersonProperties personProperties;

    @Bean("cc")
    public Map init(){
        System.out.println(personProperties);
        return new HashMap();
    }

}
