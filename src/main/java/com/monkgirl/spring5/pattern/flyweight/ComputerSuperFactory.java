package com.monkgirl.spring5.pattern.flyweight;

import com.monkgirl.spring5.pattern.factoy.Computer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 16:26
 * @description
 */
public class ComputerSuperFactory {
    private static final Map<String, Computer> computerMap = new HashMap<>();

    public static Computer getComputer(String brand) {
        Computer computer = computerMap.get(brand);
        if (computer == null) {
            computer = new ComputerProducer(brand);
            computerMap.put(brand, computer);
        }
        return computer;
    }
}
