package com.monkgirl.spring5.chapter19.spi.impl;

import com.monkgirl.spring5.chapter19.spi.SpiHelloService;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-21 17:30
 * @description
 */
public class ChineseSpiHelloServiceImpl implements SpiHelloService {
    @Override
    public void say() {
        System.out.println("你好，世界！");
    }
}
