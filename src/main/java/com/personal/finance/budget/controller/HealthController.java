package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.response.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Mono<HealthResponse> health() {
        return Mono.just(HealthResponse.builder())
                .map(builder -> builder.status("Ok").build());
    }

}
