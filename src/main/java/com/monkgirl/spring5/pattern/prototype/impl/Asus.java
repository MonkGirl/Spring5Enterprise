package com.monkgirl.spring5.pattern.prototype.impl;

import com.monkgirl.spring5.pattern.prototype.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-22 17:25
 * @description
 */
public class Asus extends Computer {
    @Override
    public void make() {
        System.out.println("produce a asus computer.");
    }
}
