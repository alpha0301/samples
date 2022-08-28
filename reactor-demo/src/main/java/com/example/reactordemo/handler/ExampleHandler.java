package com.example.reactordemo.handler;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;

@Component
public class ExampleHandler {
    public Mono<Integer> throwIndexOutOfBound() {
        int seconds = LocalTime.now().getSecond();
        Mono<Integer> element;

        if (seconds % 2 == 0)
            element = Flux.range(1, 4).elementAt(5);
        else if (seconds % 3 == 0)
            element = Flux.range(0, 4).elementAt(5);
        else
            element = Flux.just(1, 2, 3, 4).elementAt(5);

        return element;
    }


    public Flux<Integer> getSequencesToNine() {
        return Flux.range(0, 10);
    }

    public Mono<Long> runAfterHours(int hour, Runnable after) {
        return Mono.delay(Duration.ofHours(hour))
                .doOnNext(v -> {
                    System.out.println("## do after " + hour + " hours");
                    after.run();
                });
    }
}
