package com.monkgirl.spring5.comm.entities;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 15:18
 * @description
 */
@Component
public class Waiter {
    public String serve(String name){
        System.out.println("Hello " + name + " !");
        return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public void driving(String name) throws Exception {
        System.out.println(name  + " is driving...");
        //throw new Exception("driving crash...");
    }
}
