package com.monkgirl.spring5.pattern.flyweight;

import com.monkgirl.spring5.pattern.factoy.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 16:24
 * @description
 */
public class ComputerProducer implements Computer {
    private String brand;

    public ComputerProducer(String brand) {
        this.brand = brand;
    }

    @Override
    public void make() {
        System.out.println("Make a " + brand + " computer.");
    }
}
