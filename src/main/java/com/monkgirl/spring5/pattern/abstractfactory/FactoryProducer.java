package com.monkgirl.spring5.pattern.abstractfactory;

import org.apache.commons.lang.StringUtils;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:28
 * @description
 */
public class FactoryProducer {
    private FactoryProducer(){

    }
    public static AbstractFactory getFactory(String factoryType){
        if(StringUtils.isNotBlank(factoryType)) {
            switch (factoryType.toLowerCase()) {
                case "computer":
                    return new ComputerFactory();
                case "price":
                    return new PriceFactory();
                default:
                    return null;
            }
        }
        return null;
    }
}
