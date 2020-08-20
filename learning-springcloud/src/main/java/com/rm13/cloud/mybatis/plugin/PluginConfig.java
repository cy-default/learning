package com.rm13.cloud.mybatis.plugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/12
 */
@Configuration
public class PluginConfig {

    /**
     * 配置脱敏插件使之生效
     *
     * @return
     */
    @Bean
    public SensitivePlugin sensitivePlugin() {
        return new SensitivePlugin();
    }
}
