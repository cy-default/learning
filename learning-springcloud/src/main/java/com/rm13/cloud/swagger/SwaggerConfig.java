package com.rm13.cloud.swagger;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

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
        // 添加header请求头
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("snmt_mini_token")
                .description("snmt_mini_token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        //根据每个方法名也知道当前方法在设置什么参数
        pars.add(ticketPar.build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cloud-登陆校验")
                //.host(host) 自定义请求URL
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.rm13.cloud.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                // 是否开启api
                .enable(enable);
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
                // 是否开启api
                .enable(enable);
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
                // 是否开启api
                .enable(enable);
    }

    @Bean
    public Docket stringtrim() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cloud-参数格式化")
                //.host(host) 自定义请求URL
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rm13.cloud.controller.StringTrimController"))
                .paths(PathSelectors.any())
                .build()
                // 是否开启api
                .enable(enable);
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
