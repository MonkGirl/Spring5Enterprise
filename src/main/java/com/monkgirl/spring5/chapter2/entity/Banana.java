package com.monkgirl.spring5.chapter2.entity;

import com.monkgirl.spring5.chapter2.service.Eatable;
import org.springframework.stereotype.Service;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 22:23
 */
@Service
public class Banana implements Eatable {
    @Override
    public void eat() {
        System.out.println("eating banana...");
    }
}
