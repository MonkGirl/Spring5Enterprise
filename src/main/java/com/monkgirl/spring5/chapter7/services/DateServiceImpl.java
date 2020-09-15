package com.monkgirl.spring5.chapter7.services;

import com.monkgirl.spring5.chapter7.interfaces.DateService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-14 14:39
 * @description
 */
@Service
public class DateServiceImpl implements DateService {
    @Override
    public String queryCurrentDate() {

        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    }
}
