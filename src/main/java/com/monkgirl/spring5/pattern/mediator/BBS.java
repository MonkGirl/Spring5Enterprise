package com.monkgirl.spring5.pattern.mediator;

import java.util.Date;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 10:08
 * @description
 */
public class BBS {
    private BBS() {

    }

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "]\t: " + message);
    }
}
