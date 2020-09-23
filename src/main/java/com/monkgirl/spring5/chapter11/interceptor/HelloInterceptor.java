package com.monkgirl.spring5.chapter11.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-22 15:19
 * @description
 */
public class HelloInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.printf("进入preHandle方法，请求URL=%s，请求URI=%s%n", request.getRequestURL().toString(),
                request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        System.out.printf("进入postHandle方法，请求URL=%s，请求URI=%s%n", request.getRequestURL().toString(),
                request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        System.out.printf("进入afterCompletion方法，请求URL=%s，请求URI=%s%n", request.getRequestURL().toString(),
                request.getRequestURI());
    }
}
