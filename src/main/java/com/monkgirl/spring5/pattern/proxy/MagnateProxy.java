package com.monkgirl.spring5.pattern.proxy;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 16:46
 * @description
 */
public class MagnateProxy implements ByHouse{
    private Magnate magnate;

    public MagnateProxy(Magnate magnate){
        this.magnate = magnate;
    }

    public void buy(){
        magnate.buy();
    }
}
