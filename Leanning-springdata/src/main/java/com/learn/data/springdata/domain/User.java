package com.learn.data.springdata.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/25
 */
@Data
@Document("tb_user")
public class User {
    @Id
    private String id;

    private String name;

    private String address;

    private Account account;
}


