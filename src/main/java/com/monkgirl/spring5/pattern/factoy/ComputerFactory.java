package com.monkgirl.spring5.pattern.factoy;

import com.monkgirl.spring5.pattern.factoy.impl.Asus;
import com.monkgirl.spring5.pattern.factoy.impl.Lenovo;
import com.monkgirl.spring5.pattern.factoy.impl.Macbook;
import org.apache.commons.lang.StringUtils;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-22 17:29
 * @description
 */
public class ComputerFactory {
    public Computer createComputer(String type) {
        if (StringUtils.isNotBlank(type)) {
            switch (type.toLowerCase()) {
                case "asus":
                    return new Asus();
                case "lenovo":
                    return new Lenovo();
                case "macbook":
                    return new Macbook();
                default:
                    return null;
            }
        } else {
            return null;
        }
    }
}
