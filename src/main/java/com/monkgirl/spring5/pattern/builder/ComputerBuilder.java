package com.monkgirl.spring5.pattern.builder;

import com.monkgirl.spring5.pattern.builder.abstractitem.impl.AMD;
import com.monkgirl.spring5.pattern.builder.abstractitem.impl.DELL;
import com.monkgirl.spring5.pattern.builder.abstractitem.impl.Intel;
import com.monkgirl.spring5.pattern.builder.abstractitem.impl.PHILIPS;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 17:00
 * @description
 */
public class ComputerBuilder {
    public Computer buildCheap() {
        Computer computer = new Computer();
        computer.addItem(new AMD());
        computer.addItem(new PHILIPS());
        return computer;
    }

    public Computer buildExpensive() {
        Computer computer = new Computer();
        computer.addItem(new Intel());
        computer.addItem(new DELL());
        return computer;
    }
}
