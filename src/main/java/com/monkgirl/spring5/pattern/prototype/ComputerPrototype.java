package com.monkgirl.spring5.pattern.prototype;

import com.monkgirl.spring5.pattern.prototype.impl.Asus;
import com.monkgirl.spring5.pattern.prototype.impl.Lenovo;
import com.monkgirl.spring5.pattern.prototype.impl.Macbook;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-26 15:58
 * @description
 */
public class ComputerPrototype {
    private ComputerPrototype(){

    }
    private static final Map<String, Computer> computerMap = new HashMap<>();

    static {
        computerMap.put("ASUS", new Asus());
        computerMap.put("LENOVO", new Lenovo());
        computerMap.put("MACBOOK", new Macbook());
    }

    public static Computer getComputer(String type) {
        if (StringUtils.isNotBlank(type)) {
            Computer computer = computerMap.get(type.toUpperCase());
            if (computer != null) {
                return (Computer) computer.clone();
            }
        }
        return null;
    }
}
