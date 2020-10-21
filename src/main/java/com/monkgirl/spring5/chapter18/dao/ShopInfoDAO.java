package com.monkgirl.spring5.chapter18.dao;

import com.monkgirl.spring5.chapter18.entities.ShopInfo;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 11:08
 * @description
 */
public interface ShopInfoDAO {
    /**
     * 保存商户信息
     *
     * @param shopInfo 商户信息
     * @return 保存结果
     */
    int insert(ShopInfo shopInfo);

    /**
     * 查询商户信息
     *
     * @param shopId 商户ID
     * @return 商户信息
     */
    ShopInfo selectByPrimaryKey(Long shopId);

    int insertAutoIncrement(ShopInfo shopInfo);
}
