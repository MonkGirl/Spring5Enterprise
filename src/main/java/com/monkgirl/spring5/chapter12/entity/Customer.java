package com.monkgirl.spring5.chapter12.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    /**
     * 客户ID
     */
    private Integer id;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户手机号
     */
    private String phone;

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

