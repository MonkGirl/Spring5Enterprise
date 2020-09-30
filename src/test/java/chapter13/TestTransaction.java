package chapter13;

import com.monkgirl.spring5.chapter13.dao.AccountBalanceDAO;
import com.monkgirl.spring5.chapter13.entity.AccountBalance;
import com.monkgirl.spring5.chapter13.service.AccountBalanceService;
import freemarker.template.utility.NumberUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-24 11:50
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
class TestTransaction {

    private AccountBalanceService accountBalanceService;

    @Autowired
    public void setAccountBalanceService(AccountBalanceService accountBalanceService) {
        this.accountBalanceService = accountBalanceService;
    }

    @Test
    void testQuery(){
        double result = accountBalanceService.queryAccountByCustomerId(7);
        assert result != 0.0 : "账户余额为0";
        System.out.println("余额：" +  result);
    }

    @Test
    void testSave(){
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.setCustomerId(7);
        accountBalance.setBalance(BigDecimal.valueOf(108000.00));
        accountBalanceService.saveAccountBalance(accountBalance);
    }
}
