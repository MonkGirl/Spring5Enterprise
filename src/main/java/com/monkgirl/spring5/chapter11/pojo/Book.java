package com.monkgirl.spring5.chapter11.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-21 17:23
 * @description
 */
public class Book {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    private String author;
}
