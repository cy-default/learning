package com.rm13.cloud.pagehelper;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/28
 */
public interface TemplateService extends BaseService<TemplateReqQuery, TemplateeRespVO> {

    // 同为interface接口, 业务Service只需要继承BaseService
    // 并根据实际使用场景声明请求参数和响应结果的Entity实体即可
}
