package com.monkgirl.spring5.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 14:27
 * @description
 */
public class Staff {
    private int id;
    private String name;
    private String dept;
    private List<Staff> subordinateList;

    public Staff(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        subordinateList = new ArrayList<>();
    }

    public void addSubordinateList(Staff staff) {
        subordinateList.add(staff);
    }

    public List<Staff> getSubordinateList() {
        return subordinateList;
    }

    public String toString() {
        return "Employee :[ id : " + id + ", name : " + name + ", dept: " + dept + "] ";
    }
}
