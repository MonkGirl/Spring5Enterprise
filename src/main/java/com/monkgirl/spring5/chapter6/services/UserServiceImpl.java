package com.monkgirl.spring5.chapter6.services;

import com.monkgirl.spring5.chapter6.entities.User;
import com.monkgirl.spring5.chapter6.interfaces.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-08 11:07
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    private static Map<Long, User> userMap = new HashMap<>(4);
    static{
        userMap.put(1L, new User(1L, "admin1"));
        userMap.put(2L, new User(2L, "admin2"));
        userMap.put(3L, new User(3L, "admin3"));
    }
    @Override
    public Flux<User> queryAllUserList() {
        return Flux.fromIterable(userMap.values());
    }

    @Override
    public Mono<User> queryUserById(Long id) {
        return Mono.just(userMap.get(id));
    }
}
