package com.rm13.cloud.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.rm13.cloud.domain.dto.excel.OverViewDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/13
 */
@Slf4j
public class OverViewListener extends AnalysisEventListener<OverViewDTO> {

    private ArrayList<Object> result;

    public OverViewListener(ArrayList<Object> result) {
        this.result = result;
    }

    @Override
    public void invoke(OverViewDTO data, AnalysisContext context) {
        // 做业务逻辑处理
        result.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("OverViewListener.doAfterAllAnalysed");
    }
}
