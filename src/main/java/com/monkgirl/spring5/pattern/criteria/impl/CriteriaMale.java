package com.monkgirl.spring5.pattern.criteria.impl;

import com.monkgirl.spring5.pattern.criteria.Criteria;
import com.monkgirl.spring5.pattern.criteria.Person;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 11:19
 * @description
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        if (CollectionUtils.isNotEmpty(personList)) {
            return personList.stream()
                    .filter(person -> "male".equalsIgnoreCase(person.getGender())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
