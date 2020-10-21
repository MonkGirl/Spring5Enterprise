package com.monkgirl.spring5.chapter17.dao;

import com.monkgirl.spring5.chapter17.entities.Item;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-12 17:07
 * @description
 */
public interface ItemDAO {
    int save(Item item);
    Item query(int id);
}
