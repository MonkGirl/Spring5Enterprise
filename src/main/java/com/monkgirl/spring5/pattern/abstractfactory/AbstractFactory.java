package com.monkgirl.spring5.pattern.abstractfactory;

import com.monkgirl.spring5.pattern.factoy.Computer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:18
 * @description
 */
public interface AbstractFactory {
    default Computer createComputer(String type){
        return null;
    }

    default Price createPrice(String currency){
        return null;
    }
}
