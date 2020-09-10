package com.monkgirl.spring5.chapter6.interfaces;

import com.monkgirl.spring5.chapter6.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-08 11:03
 * @description
 */
public interface UserService {
    /**
     * 查询所有用户
     * @return 所有用户
     */
    Flux<User> queryAllUserList();

    /**
     * 查询单个用户
     * @param id 用户编号
     * @return 单个用户
     */
    Mono<User> queryUserById(Long id);
}
