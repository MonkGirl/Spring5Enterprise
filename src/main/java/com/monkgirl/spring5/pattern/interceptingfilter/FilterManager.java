package com.monkgirl.spring5.pattern.interceptingfilter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 17:13
 * @description
 */
public class FilterManager {
    private final FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(){
        filterChain.execute();
    }
}
