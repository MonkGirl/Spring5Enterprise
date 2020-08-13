package com.monkgirl.spring5.chapter2.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-11 17:12
 * @description
 */
@Component
public class BeanFactoryLifeCycle implements BeanFactoryPostProcessor {

    public BeanFactoryLifeCycle(){
        System.out.println("BeanFactoryLifeCycle Constructor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory...");
    }
}
