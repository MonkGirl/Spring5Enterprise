package com.monkgirl.spring5.pattern.builder.impl;

import com.monkgirl.spring5.pattern.builder.interfaces.Packing;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:51
 * @description
 */
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Packing ";
    }
}
