package com.monkgirl.spring5.chapter6.webflux;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-07 10:37
 * @description
 */
public class FluxMain {

    public void demo() {
        // 基于数组的声明方式
        Integer[] array = IntStream.range(1, 7).boxed().toArray(Integer[]::new);
        Flux.fromArray(array);

        //基于集合式声明
        Flux.fromIterable(Arrays.asList(array));

        //基于Stream声明
        Flux.fromStream(IntStream.range(1, 7).boxed());

        //只有完成信号的空数据流
        Flux.just();
        Flux.empty();
        Mono.empty();
        Mono.justOrEmpty(Optional.empty());

        //只有错误信号的数据流
        Flux.error(new Exception("some exception"));
        Mono.error(new Exception("some exception"));
    }

    public void firstDemo() {
        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print);
        System.out.println("\n-------------------");
        Mono.just(1).subscribe(System.out::print);
        System.out.println("\n-------------------");
        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print, System.err::print);
        System.out.println("\n-------------------");
        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print, System.err::print, () -> System.out.println("\nComplete"));
        System.out.println("\n-------------------");
        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print, System.err::print, () -> System.out.println("\nComplete"),
                subscription -> {
                    System.out.println("subscription");
                    subscription.request(10);
                });
    }


}
