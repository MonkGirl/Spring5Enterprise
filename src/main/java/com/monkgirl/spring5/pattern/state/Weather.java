package com.monkgirl.spring5.pattern.state;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 14:27
 * @description
 */
public class Weather {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public String getWeather() {
        return state.getState();
    }
}
