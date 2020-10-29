package com.monkgirl.spring5.pattern.iterator;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 09:33
 * @description
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
