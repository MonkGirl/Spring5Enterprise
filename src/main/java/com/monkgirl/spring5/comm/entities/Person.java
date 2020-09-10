package com.monkgirl.spring5.comm.entities;

import com.monkgirl.spring5.chapter2.service.Something;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 22:25
 */
@Component
public class Person implements Something{

    /*private Eatable eatable;

    @Autowired
    @Qualifier("apple")
    public void setEatable(Eatable eatable) {
        this.eatable = eatable;
    }

    public  void eatSomething(){
        eatable.eat();
    }*/

    @Override
    public void doSomething(){
        System.out.println("This is Person, doSomething...");
    }

    public void say(){
        System.out.println("Hello Spring 5.");
    }
}
