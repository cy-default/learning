package com.remotes.design.state;

/**
 * 电扇状态机状态
 * <p>
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/6
 */
public interface IState {

    /**
     * 获取状态名称
     *
     * @return
     */
    String getName();

    /**
     * lowSpeed
     */
    default void lowSpeed(ElectricFanMachine electricFanMachine) {
        throw new UnsupportedOperationException("不支持lowSpeed");
    }

    /**
     * mediumSpeed
     */
    default void mediumSpeed(ElectricFanMachine electricFanMachine) {
        throw new UnsupportedOperationException("不支持mediumSpeed");
    }

    /**
     * highSpeed
     */
    default void highSpeed(ElectricFanMachine electricFanMachine) {
        throw new UnsupportedOperationException("不支持highSpeed");
    }

    /**
     * turningOff
     */
    default void turningOff(ElectricFanMachine electricFanMachine) {
        throw new UnsupportedOperationException("不支持turningOff");
    }
}
