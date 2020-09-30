package com.monkgirl.spring5.chapter13.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class AccountBalance implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 客户账号
     */
    private Integer customerId;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    /**
     * 添加时间
     */
    private Date addDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;
}

