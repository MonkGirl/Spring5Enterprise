package com.monkgirl.spring5.chapter3.aspect;

import com.monkgirl.spring5.comm.entities.DefaultListener;
import com.monkgirl.spring5.comm.interfaces.Listener;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-24 16:15
 * @description
 */
@Aspect
@Component
public class ListenerAspect implements Ordered {

    @DeclareParents(value="com.monkgirl.spring5.comm.entities.FoodFactory", defaultImpl = DefaultListener.class)
    public Listener listener;

    @Override
    public int getOrder(){
        return 2;
    }
}
