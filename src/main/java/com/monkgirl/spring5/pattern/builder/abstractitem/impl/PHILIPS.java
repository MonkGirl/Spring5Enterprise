package com.monkgirl.spring5.pattern.builder.abstractitem.impl;

import com.monkgirl.spring5.pattern.builder.abstractitem.Screen;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 16:50
 * @description
 */
public class PHILIPS extends Screen {
    @Override
    public String name() {
        return "PHILIPS Screen";
    }

    @Override
    public int price() {
        return 2500;
    }
}
