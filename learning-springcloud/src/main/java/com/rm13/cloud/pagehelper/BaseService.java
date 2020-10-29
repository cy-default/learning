package com.rm13.cloud.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rm13.cloud.model.base.PageParam;

import java.util.List;

/**
 * 分页基础类（分页和集合查询解耦）
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/28
 */

/**
 * @param <Param>  泛型request
 * @param <Result> 泛型response
 */
public interface BaseService<Param, Result> {

    /**
     * 分页查询
     *
     * @param param 请求参数DTO
     * @return 分页集合
     */
    default PageInfo<Result> page(PageParam<Param> param) {
        PageInfo<Result> pageInfo = PageHelper.startPage(param).doSelectPageInfo(() -> list(param.getParam()));
        return pageInfo;
    }

    /**
     * 集合查询
     *
     * @param param 查询参数
     * @return 查询响应
     */
    List<Result> list(Param param);
}