package com.monkgirl.spring5.pattern.prototype.impl;

import com.monkgirl.spring5.pattern.prototype.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-22 17:25
 * @description
 */
public class Asus extends Computer {
    private static int no = 0;
    private final int id;

    public Asus() {
        id = no++;
    }

    public int getId() {
        return id;
    }

    @Override
    public void make() {
        System.out.println("produce a asus computer.");
    }
}
