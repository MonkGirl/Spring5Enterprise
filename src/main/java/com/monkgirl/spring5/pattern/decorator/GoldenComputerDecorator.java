package com.monkgirl.spring5.pattern.decorator;

import com.monkgirl.spring5.pattern.factoy.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 15:21
 * @description
 */
public class GoldenComputerDecorator extends ComputerDecorator {
    public GoldenComputerDecorator(Computer computer) {
        super(computer);
    }

    public void make(){
        super.make();
        paintColor();
    }

    private void paintColor(){
        System.out.println("Paint golden...");
    }
}
