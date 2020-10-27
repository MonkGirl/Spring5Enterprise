package com.monkgirl.spring5.pattern.builder.abstractitem;

import com.monkgirl.spring5.pattern.builder.impl.Wrapper;
import com.monkgirl.spring5.pattern.builder.interfaces.Item;
import com.monkgirl.spring5.pattern.builder.interfaces.Packing;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:54
 * @description
 */
public abstract class CPU implements Item {
    public Packing packing(){
        return new Wrapper();
    }
}
