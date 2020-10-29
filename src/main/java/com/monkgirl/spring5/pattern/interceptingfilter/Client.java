package com.monkgirl.spring5.pattern.interceptingfilter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 17:15
 * @description
 */
public class Client {
    private FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest() {
        filterManager.filterRequest();
    }
}
