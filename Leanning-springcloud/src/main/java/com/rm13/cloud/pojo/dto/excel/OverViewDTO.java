package com.rm13.cloud.pojo.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/13
 */
@Data
public class OverViewDTO implements Serializable {

    /**
     * 安防实况
     * 82%;803;118;60;92%;16;88
     */
    @ExcelProperty("安防实况")
    private String overViewSecurity;

    /**
     * 消防实况
     * 84%;803;118;60;92%;160;88
     */
    @ExcelProperty("消防实况")
    private String overViewFire;

    /**
     * 进入人群实况
     * 82;22;8
     */
    @ExcelProperty("进入人群实况")
    private String overViewCrewd;

    /**
     * 车辆通行情况
     * 92;165;200;207;800
     */
    @ExcelProperty("车辆通行情况")
    private String overViewCar;

    /**
     * 实时车辆通行情况图
     * 20;30;0;10;20;40;50;60;10;50;40;20
     */
    @ExcelProperty("实时车辆通行情况图")
    private String overViewCarRealTime;

    /**
     * 平均车辆通行情况图
     * 20;30;0;10;20;40;50;60;10;50;40;20
     */
    @ExcelProperty("平均车辆通行情况图")
    private String overViewCarAvarage;

    /**
     * 实时事件提醒
     * C:C区烟雾报警器报警;A:A区有人进入禁区;B:B区发生火灾报警
     */
    @ExcelProperty("实时事件提醒")
    private String overViewEvent;

    /**
     * 营运数据
     * 32;200;5;60;0;1300;92%
     */
    @ExcelProperty("营运数据")
    private String overViewService;

    /**
     * 营收情况
     * 17W;12W
     */
    @ExcelProperty("营收情况")
    private String overViewRevenue;

    /**
     * 能源监测
     * 12万w-h;16万w-h;12万
     */
    @ExcelProperty("能源监测")
    private String overViewEnergy;

    /**
     * 园区实际用电趋势
     * 20;30;0;10;20;40;50;60;10;50;40;20
     */
    @ExcelProperty("园区实际用电趋势")
    private String overViewEnergyElectricRealTime;

    /**
     * 园区平均用电趋势
     * 20;30;0;10;20;40;50;60;10;50;40;20
     */
    @ExcelProperty("园区平均用电趋势")
    private String overViewEnergyElectricAvarage;

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
