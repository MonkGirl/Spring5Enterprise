package com.monkgirl.spring5.chapter2.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-05 00:17
 */
@Service
public class BeanLifeCycle implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public BeanLifeCycle() {
        System.out.println("1. bean-level: Constructor");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("2. bean-level: setBeanName");
    }

    @Override
    public void destroy() {
        System.out.println("8. bean-level: destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("5. bean-level: afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("3. bean-level: setApplicationContext");
    }

    public void showLifeCycle() {
        System.out.println("6. bean-level: show lifeCycle...");
    }

    @PostConstruct
    public void lifeCycleInit() {
        System.out.println("4. bean-level: lifeCycleInit...");
    }

    @PreDestroy
    public void lifeCycleDestroy() {
        System.out.println("7. bean-level: lifeCycleDestroy...");
    }
}
