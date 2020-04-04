package com.monkgirl.spring5.chapter2.entity;

import com.monkgirl.spring5.chapter2.service.Something;
import org.springframework.stereotype.Service;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 22:25
 */
@Service
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
}
