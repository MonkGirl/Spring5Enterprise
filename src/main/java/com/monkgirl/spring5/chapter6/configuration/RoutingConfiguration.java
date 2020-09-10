package com.monkgirl.spring5.chapter6.configuration;

import com.monkgirl.spring5.chapter6.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;



/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-08 16:39
 * @description
 */
@Configuration
public class RoutingConfiguration  {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(UserHandler userHandler){
        return RouterFunctions.route(GET("/users/all")
                .and(accept(MediaType.APPLICATION_JSON)),userHandler::queryAllUserList)
                .andRoute(GET("/users/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)),userHandler::queryUserById);
    }
}
