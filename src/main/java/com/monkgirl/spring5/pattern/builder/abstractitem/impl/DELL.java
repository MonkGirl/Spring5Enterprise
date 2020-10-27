package com.monkgirl.spring5.pattern.builder.abstractitem.impl;

import com.monkgirl.spring5.pattern.builder.abstractitem.Screen;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 16:49
 * @description
 */
public class DELL extends Screen {
    @Override
    public String name() {
        return "DELL Screen";
    }

    @Override
    public int price() {
        return 4000;
    }
}
