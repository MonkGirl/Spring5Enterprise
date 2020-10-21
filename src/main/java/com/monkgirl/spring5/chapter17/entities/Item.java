package com.monkgirl.spring5.chapter17.entities;

import java.util.Date;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-12 17:00
 * @description
 */
public class Item {
    private int id;
    private int value;
    private Date addDate;
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
