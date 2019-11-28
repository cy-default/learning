package com.rm13.springboot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActionLogDTO {

    private String description;
    private String method;
    private String params;
}
