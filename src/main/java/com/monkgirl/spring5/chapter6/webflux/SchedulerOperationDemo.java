package com.monkgirl.spring5.chapter6.webflux;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-07 16:06
 * @description
 */
public class SchedulerOperationDemo {

    public String hello(){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Hello, Reactor!";
    }

    public void helloAsync(){
        Mono.fromCallable(this::hello)
                .subscribeOn(Schedulers.elastic())
                .subscribe(System.out::println, System.err::println);
    }
}
