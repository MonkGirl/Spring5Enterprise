package com.monkgirl.spring5.chapter18.service;

import com.monkgirl.spring5.chapter18.dao.ShopInfoDAO;
import com.monkgirl.spring5.chapter18.entities.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 11:11
 * @description
 */
@Service
public class ShopInfoService {
    private ShopInfoDAO shopInfoDAO;

    @Autowired
    public void setShopInfoDAO(ShopInfoDAO shopInfoDAO) {
        this.shopInfoDAO = shopInfoDAO;
    }

    /**
     * 保存商户
     *
     * @param shopInfo 商户信息
     */
    public void saveShop(ShopInfo shopInfo) {
        shopInfoDAO.insert(shopInfo);
    }

    /**
     * 查询商户信息
     *
     * @param userId 商户ID
     * @return 商户信息
     */
    public ShopInfo queryShop(Long userId) {
        return shopInfoDAO.selectByPrimaryKey(userId);
    }

    public void saveShopAutoIncrement(ShopInfo shopInfo){
        shopInfoDAO.insertAutoIncrement(shopInfo);
    }
}
