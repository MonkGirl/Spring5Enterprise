package com.monkgirl.spring5.pattern.chainofresponsibility;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 17:20
 * @description
 */
public abstract class AbstractFilter {
    private AbstractFilter nextAbstractFilter;

    public void setNextAbstractFilter(AbstractFilter nextAbstractFilter){
        this.nextAbstractFilter = nextAbstractFilter;
    }

    public String filter(String content){
        String filtered = doFilter(content);
        if(nextAbstractFilter != null){
            return nextAbstractFilter.filter(filtered);
        }
        return filtered;
    }

    protected abstract String doFilter(String content);
}
