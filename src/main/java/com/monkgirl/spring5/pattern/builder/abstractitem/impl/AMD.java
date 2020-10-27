package com.monkgirl.spring5.pattern.builder.abstractitem.impl;

import com.monkgirl.spring5.pattern.builder.abstractitem.CPU;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 16:47
 * @description
 */
public class AMD extends CPU {
    @Override
    public String name() {
        return "AMD Processor";
    }

    @Override
    public int price() {
        return 2000;
    }
}
