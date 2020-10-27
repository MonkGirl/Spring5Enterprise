package com.monkgirl.spring5.pattern.prototype;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-22 17:24
 * @description
 */
public abstract class Computer implements Cloneable{
    protected String type;
    public void make(){

    }

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
