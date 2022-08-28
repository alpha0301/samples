package com.example.reactordemo.config;

import com.example.reactordemo.dto.DepositRequest;
import com.example.reactordemo.entity.Account;
import com.example.reactordemo.handler.ExampleHandler;
import com.example.reactordemo.handler.GetBankHandler;
import com.example.reactordemo.handler.SampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> example() {
        return RouterFunctions.route()
                .GET("/echo",
                        request -> ServerResponse.ok().body(BodyInserters.fromPublisher(request.bodyToMono(String.class).log(), String.class)))
                .GET("/hello",
                        request -> ServerResponse.ok().body(BodyInserters.fromPublisher(Mono.just("Hello").log(), String.class)))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> debug(ExampleHandler exampleHandler) {
        return RouterFunctions.route()
                .GET("/debug",
                        request -> ServerResponse.ok().body(BodyInserters.fromPublisher(exampleHandler.throwIndexOutOfBound(), Integer.class)))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> bank(GetBankHandler handler,
                                               SampleHandler sampleHandler) {
        // test sample

        DepositRequest request = DepositRequest.create(1, 500);


        return RouterFunctions.route()
                .GET("/bank/deposit",
                        req -> ServerResponse.ok().body(BodyInserters.fromPublisher(handler.deposit(request), Account.class)))
                .GET("/bank/sample",
                        req -> ServerResponse.ok().body(BodyInserters.fromPublisher(sampleHandler.build().then(Mono.just("success")), String.class)))
                .build();
    }
}
