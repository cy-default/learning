package com.rm13.cloud.model.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/13
 */
@Data
public class EnergyDTO implements Serializable {

    /**
     * 今日能效
     */
    @ExcelProperty("今日能效")
    private String energyTodayElectric;

    /**
     * 今日实时用电趋势
     */
    @ExcelProperty("今日实时用电趋势")
    private String energyTodayElectricTrend;

    /**
     * 今日平均用电趋势
     */
    @ExcelProperty("今日平均用电趋势")
    private String energyTodayAverageElectricTrend;

    /**
     * 各项用电量分布
     */
    @ExcelProperty("各项用电量分布")
    private String energyElectricDistributionStatistic;

    /**
     * 去年用电统计
     */
    @ExcelProperty("去年用电统计")
    private String energyLastYearElectricStatistic;

    /**
     * 今年用电统计
     */
    @ExcelProperty("今年用电统计")
    private String energyThisYearElectricStatistic;

    /**
     * 同比节能
     */
    @ExcelProperty("同比节能")
    private String energyYearToYearElectricStatistic;

    /**
     * 实时用电监控
     */
    @ExcelProperty("实时用电监控")
    private String energyRealTimeEvent;

    /**
     * 监控事件统计
     */
    @ExcelProperty("监控事件统计")
    private String energyEventStatistic;

    /**
     * 公共设备运行情况
     */
    @ExcelProperty("公共设备运行情况")
    private String energyEquipmentOperationStatistic;

    /**
     * 楼栋一
     */
    @ExcelProperty("楼栋一")
    private String building1;

    /**
     * 楼栋二
     */
    @ExcelProperty("楼栋二")
    private String building2;

    /**
     * 楼栋三
     */
    @ExcelProperty("楼栋三")
    private String building3;

    /**
     * 楼栋四
     */
    @ExcelProperty("楼栋四")
    private String building4;

    /**
     * 楼栋五
     */
    @ExcelProperty("楼栋五")
    private String building5;

}
