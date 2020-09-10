package com.monkgirl.spring5.chapter3.enhancer;

import com.monkgirl.spring5.comm.interfaces.Management;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 16:36
 * @description
 */
@Component
public class Manager extends DelegatingIntroductionInterceptor implements Management {
    @Override
    public void manage(String name) {
        System.out.println("This is the Manager...");
    }
}
