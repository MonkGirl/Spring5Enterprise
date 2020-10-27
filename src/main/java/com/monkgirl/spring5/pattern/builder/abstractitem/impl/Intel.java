package com.monkgirl.spring5.pattern.builder.abstractitem.impl;

import com.monkgirl.spring5.pattern.builder.abstractitem.CPU;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 16:45
 * @description
 */
public class Intel extends CPU {
    @Override
    public String name() {
        return "Intel Processor";
    }

    @Override
    public int price() {
        return 3000;
    }
}
