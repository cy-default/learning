package com.rm13.mybatis.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-15
 */
@Data
public class BookQuery {

    private Long id;

    private BigDecimal price;

    private String author;
}
