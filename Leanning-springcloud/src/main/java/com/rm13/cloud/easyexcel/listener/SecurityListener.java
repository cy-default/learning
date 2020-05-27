package com.rm13.cloud.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.rm13.cloud.pojo.dto.role.SecurityDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/13
 */
@Slf4j
public class SecurityListener extends AnalysisEventListener<SecurityDTO> {

    @Override
    public void invoke(SecurityDTO data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("OverViewListener.doAfterAllAnalysed");
    }
}
