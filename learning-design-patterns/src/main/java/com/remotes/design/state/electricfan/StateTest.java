package com.remotes.design.state.electricfan;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/6
 */
public class StateTest {

    public static void main(String[] args) {

        // 初始化关闭状态
        final ElectricFanMachine electricFanMachine = new ElectricFanMachine(new TurningOffState());

        // 切换低档
        electricFanMachine.lowSpeed();

        // 切换中档
        electricFanMachine.mediumSpeed();

        // 切换高档
        electricFanMachine.highSpeed();

        // 切换关闭
        electricFanMachine.turningOff();
    }
}
