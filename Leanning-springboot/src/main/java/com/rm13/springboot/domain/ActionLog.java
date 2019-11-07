package com.rm13.springboot.domain;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Data
public class ActionLog {

    private Long id;
    private String description;
    private String method;
    private String ip;
    private String user;
    private String params;

}
