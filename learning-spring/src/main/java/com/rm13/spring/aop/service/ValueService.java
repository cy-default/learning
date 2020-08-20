package com.rm13.spring.aop.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/20
 */
@Data
@Service
public class ValueService {

    @Value("${os.name:}")
    private String value;
}
