package com.monkgirl.spring5.pattern.memento;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 10:39
 * @description
 */
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
