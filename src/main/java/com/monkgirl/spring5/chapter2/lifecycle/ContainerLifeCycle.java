package com.monkgirl.spring5.chapter2.lifecycle;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-11 15:13
 * @description
 */
@Component
public class ContainerLifeCycle extends InstantiationAwareBeanPostProcessorAdapter {

    public ContainerLifeCycle(){
        System.out.println("1. ContainerLifeCycle constructor...");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName){
        System.out.println("2. postProcessBeforeInstantiation...");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("3. postProcessAfterInitialization...");
        return null;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName){
        System.out.println("4. postProcessProperties..." + beanName + Arrays.toString(pvs.getPropertyValues()));

        return pvs;
    }
}
