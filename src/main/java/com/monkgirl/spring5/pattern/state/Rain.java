package com.monkgirl.spring5.pattern.state;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 14:25
 * @description
 */
public class Rain implements State {
    @Override
    public String getState() {
        return "Raining...";
    }
}
