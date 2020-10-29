package com.monkgirl.spring5.pattern.nullobject;

import java.util.Arrays;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 14:45
 * @description
 */
public class ObjectFactory {
    private ObjectFactory() {

    }

    private static final String[] NAMES = {"earth", "moon", "sun"};

    public static AbstractObject getObject(String name) {
        List<String> namesList = Arrays.asList(NAMES);
        if (namesList.contains(name.toLowerCase())) {
            return new RealObject(name);
        } else {
            return new NullObject(name);
        }
    }
}
