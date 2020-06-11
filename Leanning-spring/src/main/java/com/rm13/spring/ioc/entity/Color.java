package com.rm13.spring.ioc.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Data
public class Color {

    private Car car;

    public Color() {
        log.info("Color...construactor...");
    }
}
