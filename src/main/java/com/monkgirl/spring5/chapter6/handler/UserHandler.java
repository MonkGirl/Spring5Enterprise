package com.monkgirl.spring5.chapter6.handler;

import com.monkgirl.spring5.chapter6.entities.User;
import com.monkgirl.spring5.chapter6.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-08 11:40
 * @description
 */
@Component
public class UserHandler {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> queryAllUserList(ServerRequest serverRequest){
        Flux<User> allUser = userService.queryAllUserList();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUser, User.class);
    }

    public Mono<ServerResponse> queryUserById(ServerRequest serverRequest){
        Long userId = Long.valueOf(serverRequest.pathVariable("id"));
        Mono<User> user = userService.queryUserById(userId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user, User.class);
    }
}
