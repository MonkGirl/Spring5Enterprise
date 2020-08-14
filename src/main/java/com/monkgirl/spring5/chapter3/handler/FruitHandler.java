package com.monkgirl.spring5.chapter3.handler;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-13 17:13
 * @description
 */
@Component("handler")
public class FruitHandler {
    public void startEatFruitDate(){
        System.out.println("Begin Eating Fruit Date :" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    public void endEatFruitDate(){
        System.out.println("End Eating Fruit Date :" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
