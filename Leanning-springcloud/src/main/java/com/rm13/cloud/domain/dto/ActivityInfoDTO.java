package com.rm13.cloud.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-10
 */
@Data
public class ActivityInfoDTO {
    private String name;
    private LocalDateTime birth;

}
