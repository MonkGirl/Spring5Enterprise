package com.monkgirl.spring5.pattern.abstractfactory.impl;

import com.monkgirl.spring5.pattern.abstractfactory.Price;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:17
 * @description
 */
public class Pound implements Price {
    @Override
    public void setPrice() {
        System.out.println("Pound : 852");
    }
}
