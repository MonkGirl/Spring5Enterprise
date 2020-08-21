package com.monkgirl.spring5.entities;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 14:53
 * @description
 */
@Component
public class Desk {
    public void location() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("This is Desk...");
    }
}
