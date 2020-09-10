package com.monkgirl.spring5.comm.entities;

import com.monkgirl.spring5.comm.interfaces.Fruit;
import org.springframework.stereotype.Service;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 22:23
 */
@Service
public class Banana implements Fruit {
    @Override
    public void eat() {
        System.out.println("eating banana...");
    }
}
