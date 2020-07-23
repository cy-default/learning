package com.remotes.design;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;


/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-10
 */
public abstract  class PageTemplate<R, S extends PParam> {


    public final PResult<R> pageResult(S search){
        Page page = PageHelper.startPage(search.getPageNum(), search.getPageSize());
        List<R> result = query(search);
        return new PResult(page.getTotal(), result);
    }

    public abstract List<R> query(S search);

}
