package com.remotes.design.template.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * PageHelper默认只要实体对象参数中有pageNum/pageSize 属性字段， 则默认分页。
 * 所以为了实现 自我控制分页。 所以需要将分页字段不定义为pageNum/pageSize。
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam implements Serializable {
    private int pNum = 1;
    private int pSize = 10;
}
