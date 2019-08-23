package com.remotes.design.template.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam implements Serializable {
    private int pageNum = 1;
    private int pageSize = 10;
}
