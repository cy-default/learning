package com.rm13.cloud.feign;

import com.rm13.cloud.bean.User;
import feign.*;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
@FeignClient(name = "feignProxy",
        url = "http://localhost:8080" ,
        configuration = FeignProxy.FeignProxyConfig.class,
        fallback = FeignProxyFallBack.class
)
public interface FeignProxy {


    /**
     * post请求中， form表单/json等， 参数都是@requestBody， 请求头可以通过@requestHeader设置
     * @param user
     * @return
     */
    @PostMapping(value = "/feign/after1", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     String after1(@RequestBody User user, @RequestHeader("ab")String ab);


    /**
     * // @RequestParam参数形式的值都是以get请求的方式拼接到url后面，不管请求方式是post/get
     * @param a
     * @param b
     * @param ab
     * @return
     */
    @GetMapping(value = "/feign/after2", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String after2(@RequestParam("a")String a, @RequestParam("b")String b, @RequestHeader("ab")String ab);


    @GetMapping(value = "/feign/after3", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String after3(@SpringQueryMap Map<String, String> param, @RequestHeader("ab")String ab);


    /**
     * 使用map调用post请求， 类型定义必须是Map<String, ?>, ?是Object也不行。
     * @param user
     * @param ab
     * @return
     */
    @PostMapping(value = "/feign/after4", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String after4(@RequestBody Map<String, ?> user, @RequestHeader("ab")String ab);


    class FeignProxyConfig{

         @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        /**
         * 参数编码
         * @return
         */
         @Bean
        public Encoder feignFormEncoder () {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }

        /**
         * 日志级别
         * @return
         */
        @Bean
        public Logger.Level feignLoggerLevel(){
            return Logger.Level.FULL;
        }
    }
}
