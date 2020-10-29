package com.monkgirl.spring5.pattern.chainofresponsibility;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 17:24
 * @description
 */
public class SensitiveFilter extends AbstractFilter{
    @Override
    protected String doFilter(String content) {
        return content.replace("Sensitive World", "sw");
    }
}
