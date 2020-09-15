package com.monkgirl.spring5.chapter7.controller;

import com.monkgirl.spring5.chapter7.interfaces.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-14 14:48
 * @description
 */
@RestController
public class DateController {

    private DateService dateService;

    @Autowired
    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    @RequestMapping("/date/currentDate")
    public String getCurrentDate(){
        return dateService.queryCurrentDate();
    }
}
