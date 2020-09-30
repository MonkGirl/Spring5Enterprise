package com.monkgirl.spring5.chapter14.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Book implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 书名
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

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

