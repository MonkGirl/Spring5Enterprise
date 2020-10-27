package com.monkgirl.spring5.pattern.builder.interfaces;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:49
 * @description
 */
public interface Item {
    String name();
    Packing packing();
    int price();
}
