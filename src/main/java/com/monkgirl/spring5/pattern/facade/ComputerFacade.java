package com.monkgirl.spring5.pattern.facade;

import com.monkgirl.spring5.pattern.prototype.impl.Asus;
import com.monkgirl.spring5.pattern.prototype.impl.Lenovo;
import com.monkgirl.spring5.pattern.prototype.impl.Macbook;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 16:11
 * @description
 */
public class ComputerFacade {
    private final Asus asus;
    private final Lenovo lenovo;
    private final Macbook macbook;

    public ComputerFacade() {
        this.asus = new Asus();
        this.lenovo = new Lenovo();
        this.macbook = new Macbook();
    }

    public void makeAsus(){
        asus.make();
    }

    public void makeLenovo(){
        lenovo.make();
    }

    public void makeMacbook(){
        macbook.make();
    }
}
