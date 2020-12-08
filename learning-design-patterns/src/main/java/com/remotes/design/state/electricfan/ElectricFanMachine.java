package com.remotes.design.state.electricfan;

/**
 * 电扇状态机
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/6
 */
public class ElectricFanMachine {

    private Integer windSpeed;
    private IState state;

    public ElectricFanMachine(IState state) {
        this.state = state;
    }

    /**
     * lowSpeed
     */
    public void lowSpeed() {
        this.state.lowSpeed(this);
    }

    /**
     * mediumSpeed
     */
    public void mediumSpeed() {
        this.state.mediumSpeed(this);
    }

    /**
     * highSpeed
     */
    public void highSpeed() {
        this.state.highSpeed(this);
    }

    /**
     * turningOff
     */
    public void turningOff() {
        this.state.turningOff(this);
    }


    public void setState(IState state) {
        this.state = state;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public IState getState() {
        return state;
    }
}
