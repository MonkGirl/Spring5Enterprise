package com.monkgirl.spring5.chapter17.entities;

import java.util.Date;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-12 17:01
 * @description
 */
public class CustomerOrder {
    private int id;
    private int amount;
    private Date addDate;
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
