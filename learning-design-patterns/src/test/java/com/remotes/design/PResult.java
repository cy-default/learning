package com.remotes.design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-10
 */
@Data
@AllArgsConstructor
public class PResult<T> {

    private Long total;
    private List<T> data;
}
