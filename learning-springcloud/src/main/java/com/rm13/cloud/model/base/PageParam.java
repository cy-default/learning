package com.rm13.cloud.model.base;

import com.github.pagehelper.IPage;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页请求
 * * @Accessors(chain = true) 此lombok注解是为了实现 Entity伪Build 譬如: entity.setX(x).setY(y)
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/28
 */
@Data
@Accessors(chain = true)
public class PageParam<T> implements IPage {

    /**
     * description = "页码", defaultValue =  1
     */
    private Integer pageNum = 1;

    /**
     * description = "页数", defaultValue = 20
     */
    private Integer pageSize = 20;

    /**
     * description = "排序", example = "id desc"
     */
    private String orderBy;

    /**
     * description = "参数"
     */
    private T param;

    public PageParam<T> setOrderBy(String orderBy) {
        // 此处可优化 优化详情且看解析
        this.orderBy = orderBy;
        return this;
    }
}
