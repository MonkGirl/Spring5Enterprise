package com.monkgirl.spring5.pattern.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 17:10
 * @description
 */
public class FilterChain {
    List<Filter> filterList = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter) {
        filterList.add(filter);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void execute() {
        for (Filter filter : filterList) {
            filter.doFilter();
        }
        target.execute();
    }
}
