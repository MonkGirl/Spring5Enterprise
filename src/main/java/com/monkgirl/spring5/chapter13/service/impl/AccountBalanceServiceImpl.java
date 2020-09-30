package com.monkgirl.spring5.chapter13.service.impl;

import com.monkgirl.spring5.chapter13.dao.AccountBalanceDAO;
import com.monkgirl.spring5.chapter13.entity.AccountBalance;
import com.monkgirl.spring5.chapter13.service.AccountBalanceService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-24 14:24
 * @description
 */
@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {
    private AccountBalanceDAO accountBalanceDAO;

    @Autowired
    public void setAccountBalanceDAO(AccountBalanceDAO accountBalanceDAO) {
        this.accountBalanceDAO = accountBalanceDAO;
    }

    @Override
    public double queryAccountByCustomerId(int id) {
        Object result = accountBalanceDAO.queryAccountByCustomerId(id);
        return ObjectUtils.isNotEmpty(result) ? Double.parseDouble(result.toString()) : 0.0;
    }

    @Override
    @Transactional
    public int saveAccountBalance(AccountBalance accountBalance) {
        int result = accountBalanceDAO.saveAccountBalance(accountBalance);
        int no = result / 0;
        return result;
    }

    @Override
    public int updateAccountBalance(AccountBalance accountBalance) {
        return accountBalanceDAO.updateAccountBalance(accountBalance);
    }
}
