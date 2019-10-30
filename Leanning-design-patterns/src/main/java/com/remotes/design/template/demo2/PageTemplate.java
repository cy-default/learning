package com.remotes.design.template.demo2;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * 分页。 mybatis集成PageHelper。
 * 使用模版方法规避重复代码书写
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-23
 */
public abstract class PageTemplate<T, S extends PageParam> {

    /**
     * 模版方法实现分页列表查询
     *
     * @param search
     * @param
     */
    public final PageResult<T> pageResult(S search){
        // 分页
        Page page = PageHelper.startPage(search.getPageNum(), search.getPageSize());

        // 子类实现
        List<T> result = pageQuery(search);

        // 结果
        return new PageResult(page.getTotal(), result);
    }

    /**
     * 具体到子类实现的查询逻辑
     * @return
     */
    public abstract List<T> pageQuery(S search);
}
