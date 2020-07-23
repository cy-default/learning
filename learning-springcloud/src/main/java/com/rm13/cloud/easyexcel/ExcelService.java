package com.rm13.cloud.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.google.common.collect.Lists;
import com.rm13.cloud.pojo.dto.excel.OverViewDTO;
import com.rm13.cloud.easyexcel.listener.OverViewListener;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * 有个很重要的点 OverViewListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/13
 */
@Service
public class ExcelService {

    public void parseExcel() {
        InputStream resourceAsStream = ExcelService.class.getResourceAsStream("/overview.xlsx");
        final ArrayList<Object> result = Lists.newArrayList();
        ExcelReader excelReader = EasyExcel.read(resourceAsStream, OverViewDTO.class, new OverViewListener(result)).build();
        ReadSheet readSheet = EasyExcel.readSheet(2).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}
