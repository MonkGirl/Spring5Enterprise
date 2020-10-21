package com.monkgirl.spring5.chapter18.entities;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-19 17:31
 * @description
 */
public class ShopInfo {
    /**
     * 商户ID
     */
    private Long shopId;
    /**
     * 商户名
     */
    private String shopName;
    /**
     * 商户账户
     */
    private String account;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
