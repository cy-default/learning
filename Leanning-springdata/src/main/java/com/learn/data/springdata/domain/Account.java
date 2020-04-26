package com.learn.data.springdata.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/25
 */
@Data
public class Account implements Serializable {

        private BigDecimal price;
        private String type;
}
