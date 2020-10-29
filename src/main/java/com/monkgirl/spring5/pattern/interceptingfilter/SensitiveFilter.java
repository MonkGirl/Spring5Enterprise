package com.monkgirl.spring5.pattern.interceptingfilter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 17:08
 * @description
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter() {
        System.out.println("Execute Sensitive Words Filter.");
    }
}
