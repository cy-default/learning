package com.rm13.cloud.localDateParam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * 两个bean会注入到spring mvc的参数解析器(ParameterConversionService)
 * 当传入的字符串要转为LocalDateTime类时，spring会调用该Converter对这个入参进行转换。
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/14
 */
@Configuration
public class DateConverterConfig {

    /**
     * 使用lambada表达式报错
     * IllegalArgumentException: Unable to determine source type <S> and target type <T> for your Converter [com.rm13.cloud.localDateParam.DateConverterConfig$$Lambda$569/440435702]; does the class parameterize those types?
     *
     * 需要改为使用匿名内部类
     *
     *
     * @return
     */
    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };
    }

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };
    }
}
