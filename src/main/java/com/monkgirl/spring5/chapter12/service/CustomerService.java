package com.monkgirl.spring5.chapter12.service;

import com.monkgirl.spring5.chapter12.entity.Customer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-22 19:52
 * @description
 */
public interface CustomerService {
    /**
     * 保存客户信息
     *
     * @param customer 客户信息
     * @return 保存客户个数
     */
    int save(Customer customer);

    /**
     * 更新客户信息
     *
     * @param customer 客户信息
     * @return 保存客户个数
     */
    int update(Customer customer);

    /**
     * 查询客户信息
     *
     * @param customerId 客户ID
     * @return 客户信息
     */
    Customer query(int customerId);

    /**
     * 删除客户信息
     *
     * @param customerId 客户ID
     * @return 删除客户个数
     */
    int delete(int customerId);
}
