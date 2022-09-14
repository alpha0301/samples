package com.example.reactordemo;

import com.example.reactordemo.handler.ExampleHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.atomic.LongAdder;

@SpringBootTest
public class WebFluxUnitTest {

    @Autowired
    private ExampleHandler handler;

    @Test
    void contextLoads() {

    }

    @Test
    void testChangeThreadPool() {
        Flux.range(1, 4)
//                .publishOn(Schedulers.newSingle("pub1"))
//                .subscribeOn(Schedulers.newSingle("sub1"))
//                .publishOn(Schedulers.newSingle("pub2"))
//                .subscribeOn(Schedulers.newSingle("sub2"))
                .log()
//                .publishOn(Schedulers.newSingle("pub1"))
                .map(i -> i * 10)
                .log()
//                .subscribeOn(Schedulers.newSingle("sub1"))
//                .log()
                .map(i -> "num: " + i)
                .log()
//                .subscribeOn(Schedulers.newSingle("sub1"))
//                .log()
                .subscribe();
    }

    @Test
    void testGetUnderTenWithoutOrder() {
        StepVerifier.create(handler.getSequencesToNine().log())
                .expectNext(0)
                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void testDoSomethingWithDelay() {
        final LongAdder longAdder = new LongAdder();
        System.out.println("################# " + longAdder.longValue());

        StepVerifier.withVirtualTime(() -> handler.runAfterHours(3, longAdder::increment))
                .expectSubscription()
                .expectNoEvent(Duration.ofHours(2))
                .thenAwait(Duration.ofHours(1))
                .expectNext(0L) // doOnNext 때문에 필요
                .expectComplete()
                .verify();

        System.out.println("################# " + longAdder.longValue());

    }

}
