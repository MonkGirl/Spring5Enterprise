package com.monkgirl.spring5.pattern.criteria.impl;

import com.monkgirl.spring5.pattern.criteria.Criteria;
import com.monkgirl.spring5.pattern.criteria.Person;

import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 11:28
 * @description
 */
public class AndCriteria implements Criteria {
    private final Criteria criteria;
    private final Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        return criteria.meetCriteria(otherCriteria.meetCriteria(personList));
    }
}
