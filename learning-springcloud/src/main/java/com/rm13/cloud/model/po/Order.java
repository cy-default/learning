package com.rm13.cloud.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/29
 */
@Data
public class Order implements Serializable {

    private String orderNo;

    private Long userId;

    private Long goodsId;
}
