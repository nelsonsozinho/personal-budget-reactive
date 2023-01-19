package com.personal.finance.budget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication()
public class PersonalBudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalBudgetApplication.class, args);
    }

}
