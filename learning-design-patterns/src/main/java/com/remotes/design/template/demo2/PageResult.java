package com.remotes.design.template.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T>{
    private Long total;
    private List<T> result;
}
