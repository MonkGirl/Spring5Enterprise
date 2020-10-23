package com.monkgirl.spring5.chapter19.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.monkgirl.spring5.chapter19.service.HelloService;

import java.time.LocalDateTime;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-21 11:50
 * @description
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println(LocalDateTime.now() + " hello " + name
                + ", response from provider: " + RpcContext.getContext().getLocalAddress());
        return "hello " + name;
    }
}
