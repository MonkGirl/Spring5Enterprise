package com.monkgirl.spring5.chapter12.dao;

import com.monkgirl.spring5.chapter12.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-22 17:08
 * @description
 */
@Service
public interface CustomerDAO {
    /**
     * 保存客户信息
     * @param customer 客户信息
     * @return 保存的客户数量
     */
    int save(Customer customer);

    /**
     * 删除客户信息
     * @param customer 客户信息
     * @return 更新的客户数量
     */
    int update(Customer customer);

    /**
     * 查询客户信息
     * @param id 客户ID
     * @return 客户信息
     */
    Customer query(int id);

    /**
     * 删除客户信息
     * @param id 客户ID
     * @return 删除的客户数量
     */
    int delete(int id);
}
