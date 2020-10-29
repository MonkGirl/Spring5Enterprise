package com.monkgirl.spring5.pattern.bridge;


import com.monkgirl.spring5.pattern.prototype.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 10:29
 * @description
 */
public abstract class Bridge {
    protected Computer computer;

    public Bridge(Computer computer) {
        this.computer = computer;
    }

    public abstract void makeComputer();
}
