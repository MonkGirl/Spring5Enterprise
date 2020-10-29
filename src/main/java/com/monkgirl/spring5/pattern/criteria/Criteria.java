package com.monkgirl.spring5.pattern.criteria;

import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 11:17
 * @description
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> personList);
}
