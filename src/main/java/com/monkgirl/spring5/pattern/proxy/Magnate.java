package com.monkgirl.spring5.pattern.proxy;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 16:45
 * @description
 */
public class Magnate implements ByHouse{
    @Override
    public void buy() {
        System.out.println("I am a magnate, and need a big house!");
    }
}
