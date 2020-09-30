package com.monkgirl.spring5.chapter13.service;

import com.monkgirl.spring5.chapter13.entity.AccountBalance;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-24 14:23
 * @description
 */
public interface AccountBalanceService {
    /**
     * 查询账户余额
     *
     * @param id 客户ID
     * @return 账户余额
     */
    double queryAccountByCustomerId(int id);

    /**
     * 保存账户余额
     *
     * @param accountBalance 账户余额
     * @return 账户余额
     */
    int saveAccountBalance(AccountBalance accountBalance);

    /**
     * 更新账户余额
     *
     * @param accountBalance 账户余额
     * @return 账户余额
     */
    int updateAccountBalance(AccountBalance accountBalance);
}
