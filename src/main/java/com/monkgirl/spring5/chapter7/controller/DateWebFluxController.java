package com.monkgirl.spring5.chapter7.controller;

import com.monkgirl.spring5.chapter7.interfaces.DateWebFluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-14 17:18
 * @description
 */
@RestController
public class DateWebFluxController {

    private DateWebFluxService dateWebFluxService;

    @Autowired
    public void setDateWebFluxService(DateWebFluxService dateWebFluxService) {
        this.dateWebFluxService = dateWebFluxService;
    }

    @RequestMapping("/date/webflux/getCurrentDate")
    public Mono<String> getCurrentDate(){
        return dateWebFluxService.queryCurrentDate();
    }
}
