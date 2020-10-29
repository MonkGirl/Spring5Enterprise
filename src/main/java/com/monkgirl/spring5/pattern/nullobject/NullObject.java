package com.monkgirl.spring5.pattern.nullobject;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 14:42
 * @description
 */
public class NullObject implements AbstractObject {
    private final String name;

    public NullObject(String name) {
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public void show() {
        System.out.println(name + " Object not exist");
    }
}
