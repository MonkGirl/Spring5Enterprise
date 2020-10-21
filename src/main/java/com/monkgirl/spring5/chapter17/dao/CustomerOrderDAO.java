package com.monkgirl.spring5.chapter17.dao;

import com.monkgirl.spring5.chapter17.entities.CustomerOrder;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-12 17:05
 * @description
 */
public interface CustomerOrderDAO {
    int save(CustomerOrder customerOrder);
    CustomerOrder query(int id);
}
