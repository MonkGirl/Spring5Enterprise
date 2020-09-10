package com.monkgirl.spring5.comm.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 14:54
 * @description
 */
@Component
public class Table {
    public void location() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("This is Table");
    }
}
