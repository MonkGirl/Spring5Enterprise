package com.monkgirl.spring5.comm.interfaces;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-18 16:46
 * @description
 */
public interface Factory {
    void make();

    void delivery(String address);

    default void build(Factory factory){}
}
