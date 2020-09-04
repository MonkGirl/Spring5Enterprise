package com.monkgirl.spring5.entities;

import com.monkgirl.spring5.interfaces.Listener;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-24 16:13
 * @description
 */
@Component
public class DefaultListener implements Listener{
    @Override
    public void listen() {
        System.out.println("Start Listen...");
    }
}
