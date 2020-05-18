package com.rm13.cloud.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/13
 */
@Data
public class SecurityDTO implements Serializable {

    /**
     * 今日安防事件统计
     */
    @ExcelProperty("今日安防事件统计")
    private String securityEventStatistic;

    /**
     * 今日设备统计
     */
    @ExcelProperty("今日设备统计")
    private String securityEquipmentStatistic;

    /**
     * 事件处理分析
     */
    @ExcelProperty("事件处理分析")
    private String secyrityEventHandlerAnalysis;

    /**
     * 今日门禁人流统计
     */
    @ExcelProperty("今日门禁人流统计")
    private String securityCrewdStatistic;

    /**
     * 人流分布
     */
    @ExcelProperty("人流分布")
    private String securityCrewdTrend;

    /**
     * 近一周设备异常趋势
     */
    @ExcelProperty("近一周设备异常趋势")
    private String securityEquipmentWeekTrend;

    /**
     * 实时安防提醒
     */
    @ExcelProperty("实时安防提醒")
    private String securityRealTimeEvent;

    /**
     * 近一周报警事件趋势
     */
    @ExcelProperty("近一周报警事件趋势")
    private String securityEventWeekTrend;

    /**
     * 智能门禁
     */
    @ExcelProperty("智能门禁")
    private String securityAccessControl;
}
