package com.monkgirl.spring5.comm.entities;

import com.monkgirl.spring5.comm.interfaces.Factory;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-18 16:52
 * @description
 */
@Component
public class PhoneFactory implements Factory {
    @Override
    public void make() {
        System.out.println("make phone...");
    }

    @Override
    public void delivery(String address) {
        System.out.println("delivery phone to " + address);
    }

    public void testWithin(){}
}
