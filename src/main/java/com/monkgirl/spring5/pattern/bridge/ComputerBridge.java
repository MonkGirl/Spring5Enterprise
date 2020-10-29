package com.monkgirl.spring5.pattern.bridge;


import com.monkgirl.spring5.pattern.prototype.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 10:31
 * @description
 */
public class ComputerBridge extends Bridge{
    public ComputerBridge(Computer computer) {
        super(computer);
    }

    @Override
    public void makeComputer() {
       computer.make();
    }
}
