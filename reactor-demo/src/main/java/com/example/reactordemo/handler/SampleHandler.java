package com.example.reactordemo.handler;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class SampleHandler {
    @Value("classpath:init.sql")
    private Resource initSql;

    @Autowired
    private R2dbcEntityTemplate entityTemplate;

    public Mono<Void> build() throws RuntimeException {
        String query = null;
        try {
            query = StreamUtils.copyToString(initSql.getInputStream(),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Mono<Void> mono = this.entityTemplate
                .getDatabaseClient()
                .sql(query)
                .then();

        return mono;
    }
}
