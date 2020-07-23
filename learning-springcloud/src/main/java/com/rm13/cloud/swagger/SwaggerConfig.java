package com.rm13.cloud.swagger;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * api接口文档
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Slf4j
@ConditionalOnProperty(value = "swagger.enable", havingValue = "true", matchIfMissing = true)
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${cloud.swagger.host:}")
    private String host;
    @Value("${swagger.enable:true}")
    private Boolean enable;


    @Bean
    public Docket redirectApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cloud-登陆校验")
                //.host(host) 自定义请求URL
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.rm13.cloud.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                // .enable(enable) 是否开启api
                ;
    }

    @Bean
    public Docket forwardApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cloud-转发测试")
                //.host(host) 自定义请求URL
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rm13.cloud.controller.ForwardController"))
                .paths(PathSelectors.any())
                .build()
                //.enable(enable) 是否开启api
                ;
    }

    @Bean
    public Docket argsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cloud-参数校验")
                //.host(host) 自定义请求URL
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rm13.cloud.controller.ArgsController"))
                .paths(PathSelectors.any())
                .build()
                //.enable(enable) 是否开启api
                ;
    }


    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学习项目")
                .description("学习项目接口, 提供restful类型的服务")
                .version("1.0")
                .build();
    }
}
