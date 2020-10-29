package com.monkgirl.spring5.pattern.criteria.impl;

import com.monkgirl.spring5.pattern.criteria.Criteria;
import com.monkgirl.spring5.pattern.criteria.Person;

import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 11:31
 * @description
 */
public class OrCriteria implements Criteria {
    private final Criteria criteria;
    private final Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> criteriaList = criteria.meetCriteria(personList);
        List<Person> otherCriteriaList = otherCriteria.meetCriteria(personList);
        for(Person person : criteriaList){
            otherCriteriaList.remove(person);
        }
        criteriaList.addAll(otherCriteriaList);
        return criteriaList;
    }
}
