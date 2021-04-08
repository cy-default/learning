package com.rm13.learn.mybatisplus.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分页查询
 */
@Data
public class PageQuery<T> extends Page {
    private T query;
}
