package com.rm13.cloud.pagehelper;

import com.github.pagehelper.PageInfo;
import com.rm13.cloud.model.base.PageParam;
import com.rm13.cloud.result.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/28
 */
@Slf4j
@RestController
@RequestMapping("/template")
public class TemplateController {

    private TemplateService templateService;

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @PostMapping("/page")
    public ResultResponse<PageInfo<TemplateeRespVO>> page(@RequestBody PageParam<TemplateReqQuery> query) {
        PageInfo<TemplateeRespVO> page = templateService.page(query);
        return ResultResponse.success(page);
    }


    /**
     * 集合查询
     *
     * @param query
     * @return
     */
    @PostMapping(path = "list")
    public ResultResponse<List<TemplateeRespVO>> list(@RequestBody TemplateReqQuery query) {
        List<TemplateeRespVO> list = templateService.list(query);
        return ResultResponse.success(list);
    }


}
