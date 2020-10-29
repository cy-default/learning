package com.rm13.cloud.pagehelper;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/28
 */
public interface TemplateMapper {

    List<TemplateeRespVO> selectManySelective(TemplateReqQuery param);
}
