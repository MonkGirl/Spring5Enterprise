package com.monkgirl.spring5.chapter7.interfaces;

import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-14 17:16
 * @description
 */
public interface DateWebFluxService {
    Mono<String> queryCurrentDate();
}
