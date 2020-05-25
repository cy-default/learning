package com.rm13.cloud.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Spring MVC 配置接收 String 参数时自动去除前后空格
 * @see https://www.dazhuanlan.com/2019/10/16/5da677702ca82/?__cf_chl_jschl_tk__=6f70fd96acc7555f265db85662095460590b13e5-1590053621-0-AW5dKYMPTLLlSRvY1nfEjNn7h9pAfTR_EtehGOfF7FSnYmLFjrsbfPjnHYINx5bj8O9rQmaINcqEm8H-nR4lFYDLsNiQJ21OcA8oY5Gdo0nIsk70C0g0yWCocm9ytqxliOu0a1OlV2wGHOf_rVD9FyfbnC6iV3heZ2tiQULIr9h2J0m0M7r4CixIkU3lXl797YwCJAHT8QHpqdzwWrK6ZnT6oG2hnlKK5P995MPjgNV3fZUNbFQBbFaPXDefKlzTk94U5LvdDBVc73lrxEpviPdkXgyMx2FKww-S49oq-34oCcuhPQ0heyjkbeTs7pqsXQ
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/21
 */
@Configuration
public class StringTrimConfig {


    /**
     * 接收Request Body中JSON或XML对象参数
     * 在这里，Spring MVC 是使用 Jackson 对参数进行反序列化，所以对于 String 的处理是在 Jackson 中配置
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                // 为 String 类型自定义反序列化操作
                jacksonObjectMapperBuilder
                        .deserializerByType(String.class, new StdScalarDeserializer<String>(String.class) {
                            @Override
                            public String deserialize(JsonParser jsonParser, DeserializationContext ctx)
                                    throws IOException {
                                // 去除前后空格
                                return StringUtils.trimWhitespace(jsonParser.getValueAsString());
                            }
                        });
            }
        };
    }

}
