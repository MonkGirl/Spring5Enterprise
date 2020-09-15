package com.monkgirl.spring5.chapter7.services;

import com.monkgirl.spring5.chapter7.interfaces.DateWebFluxService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-14 17:17
 * @description
 */
@Service
public class DateWebFluxServiceImpl implements DateWebFluxService {
    @Override
    public Mono<String> queryCurrentDate() {
        return Mono.just(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
    }
}
