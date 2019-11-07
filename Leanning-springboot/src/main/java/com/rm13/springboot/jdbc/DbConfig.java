package com.rm13.springboot.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 数据库配置
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Configuration
@PropertySource(value = {"classpath:hikari.properties"}, ignoreResourceNotFound = true)
public class DbConfig {

}
