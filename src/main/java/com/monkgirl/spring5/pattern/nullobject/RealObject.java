package com.monkgirl.spring5.pattern.nullobject;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 14:42
 * @description
 */
public class RealObject implements AbstractObject{
    private final String name;

    public RealObject(String name){
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public void show() {
        System.out.println("real Object " + name + " shows now");
    }
}
