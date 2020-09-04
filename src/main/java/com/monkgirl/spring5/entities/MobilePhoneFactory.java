package com.monkgirl.spring5.entities;

import com.monkgirl.spring5.annotation.Monitor;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-04 15:09
 * @description
 */
@Monitor
@Component
public class MobilePhoneFactory extends PhoneFactory{
    @Override
    public void testWithin(){

    }

    @Override
    public void delivery(String address){
        System.out.println("MobilePhone delivery to " + address);
    }
}
