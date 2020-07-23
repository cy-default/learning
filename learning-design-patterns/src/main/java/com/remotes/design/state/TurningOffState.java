package com.remotes.design.state;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/6
 */
public class TurningOffState implements IState {

    @Override
    public void lowSpeed(ElectricFanMachine electricFanMachine) {
        electricFanMachine.setState(new LowSpeedState());
        electricFanMachine.setWindSpeed(StateEnum.LOW_SPEED.getSpreed());
        System.out.println("当前状态：TurningOff，状态改变：lowSpeed, 当前风速：" + electricFanMachine.getWindSpeed());
    }

    @Override
    public void mediumSpeed(ElectricFanMachine electricFanMachine) {
        electricFanMachine.setState(new MediumSpeedState());
        electricFanMachine.setWindSpeed(StateEnum.MEDIUM_SPEED.getSpreed());
        System.out.println("当前状态：TurningOff，状态改变：mediumSpeed, 当前风速：" + electricFanMachine.getWindSpeed());
    }

    @Override
    public void highSpeed(ElectricFanMachine electricFanMachine) {
        electricFanMachine.setState(new HighSpeedState());
        electricFanMachine.setWindSpeed(StateEnum.HIGH_SPEED.getSpreed());
        System.out.println("当前状态：TurningOff，状态改变：highSpeed, 当前风速：" + electricFanMachine.getWindSpeed());
    }

    @Override
    public void turningOff(ElectricFanMachine electricFanMachine) {
        electricFanMachine.setState(new TurningOffState());
        electricFanMachine.setWindSpeed(StateEnum.TURNING_OFF.getSpreed());
        System.out.println("当前状态：TurningOff，状态改变：turningOff, 当前风速：" + electricFanMachine.getWindSpeed());
    }

    @Override
    public String getName() {
        return StateEnum.TURNING_OFF.getDesc();
    }
}
