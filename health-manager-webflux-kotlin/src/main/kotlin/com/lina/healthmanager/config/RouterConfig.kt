package com.lina.healthmanager.config

import com.lina.healthmanager.handler.VitalSignHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class RouterConfig {

    @Bean
    suspend fun route(handler: VitalSignHandler) = router {
        GET("/hello") { ServerResponse.ok().body(BodyInserters.fromValue("hello")) }
        GET("/world") { ServerResponse.ok().body(BodyInserters.fromProducer(Mono.just("world"), String::class.java)) }
        POST("/vitalSign") { handler.add("user1") }
    }

}