package com.monkgirl.spring5.chapter11.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-21 14:56
 * @description
 */
@XmlRootElement(name="user")
public class User implements Serializable {
    private String userName;
    private int userAge;

    public String getUserName() {
        return userName;
    }

    @XmlElement
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    @XmlElement
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
