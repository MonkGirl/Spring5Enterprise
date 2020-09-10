package com.monkgirl.spring5.comm.entities;

import com.monkgirl.spring5.annotation.Log;
import com.monkgirl.spring5.comm.interfaces.Factory;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-18 16:47
 * @description
 */
@Component
public class FoodFactory implements Factory{
    @Log
    @Override
    public void make() {
        System.out.println("make food...");
    }

    @Override
    public void delivery(String address) {
        System.out.println("delivery food to " + address);
    }

    public void testArgsAnnotation(FreshFoodFactory freshFoodFactory){

    }
}
