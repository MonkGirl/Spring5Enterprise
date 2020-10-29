package com.monkgirl.spring5.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 10:52
 * @description
 */
public class StateKeeper {
    private final List<Memento> mementoList = new ArrayList<>();

    public void addState(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
