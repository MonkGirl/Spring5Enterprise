package chapter6;
import com.monkgirl.spring5.chapter6.webflux.FluxMain;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-07 11:09
 * @description
 */
class TestFlux {
    @Test
    void testFirstDemo() {
        FluxMain flux = new FluxMain();
        flux.firstDemo();
    }

    @Test
    @SuppressWarnings({"unchecked", "rawtypes"})
    void stepVerifyDemo() {
        Flux flux = Flux.just(1, 2, 3, 4, 5, 6);
        StepVerifier.create(flux).expectNext(1, 2, 3, 4, 5, 6).expectComplete().verify();
        System.out.println("----------------");

        Mono mono = Mono.error(new Exception("some error"));
        StepVerifier.create(mono).expectError().verify();
        System.out.println("----------------");

        StepVerifier.create(Flux.range(1, 6).map(i -> Math.pow(i, 3)))
                .expectNext(1d, 8d, 27d, 64d, 125d, 216d).expectComplete().verify();
        System.out.println("----------------");

        StepVerifier.create(
                Flux.just("flux", "mono").flatMap(s -> Flux.fromArray(s.split("\\s*")))
                        .delayElements(Duration.ofMillis(100))
                        .doOnNext(System.out::print)
        ).expectNextCount(8).expectComplete().verify();
        System.out.println("\n----------------");

        StepVerifier.create(Flux.range(1, 6)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i * i))
                .expectNext(8, 64, 216)
                .verifyComplete();
        System.out.println("----------------");

        String desc = "I am Reactor";
        StepVerifier.create(Flux.zip(Flux.fromArray(desc.split("\\s+")), Flux.interval(Duration.ofMillis(100)))
                .doOnNext(System.out::print)).expectNextCount(3).verifyComplete();
    }
}
