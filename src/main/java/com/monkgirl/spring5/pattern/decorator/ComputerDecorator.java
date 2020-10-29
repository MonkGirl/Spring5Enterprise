package com.monkgirl.spring5.pattern.decorator;

import com.monkgirl.spring5.pattern.factoy.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 15:17
 * @description
 */
public abstract class ComputerDecorator implements Computer {
    Computer computer;

    public ComputerDecorator(Computer computer){
        this.computer = computer;
    }

    @Override
    public void make() {
        computer.make();
    }
}
