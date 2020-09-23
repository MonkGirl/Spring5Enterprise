package com.monkgirl.spring5.chapter10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-17 13:57
 * @description
 */
public class LoggerDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggerDemo.class);

    public static void main(String[] args){
        logger.info("Hello World!");
        logger.warn("Hello Java!");
    }
}
