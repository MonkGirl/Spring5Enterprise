package com.monkgirl.spring5.pattern.builder;

import com.monkgirl.spring5.pattern.builder.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 16:53
 * @description
 */
public class Computer {
    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void showItem() {
        int total = 0;
        for (Item item : itemList) {
            System.out.print(item.packing().pack() + item.name() + ", 价格=" + item.price() + "\t");
            total += item.price();
        }
        System.out.println("电脑总价=" + total);
    }
}
