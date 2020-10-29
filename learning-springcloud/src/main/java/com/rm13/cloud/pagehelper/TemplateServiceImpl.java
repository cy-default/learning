package com.rm13.cloud.pagehelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/28
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {

    private TemplateMapper mapper;

    @Override
    public List<TemplateeRespVO> list(TemplateReqQuery param) {
        //可根据实际情况将实体做转换
        return mapper.selectManySelective(param);
    }
}
