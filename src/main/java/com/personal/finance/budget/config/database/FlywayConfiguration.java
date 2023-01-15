package com.personal.finance.budget.config.database;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfiguration {

    private final String url;
    private final String user;
    private final String password;

    public FlywayConfiguration(@Value("${spring.flyway.url}") final String url,
                          @Value("${spring.flyway.user}") final String user,
                          @Value("${spring.flyway.password}") final String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return new Flyway(
                Flyway.configure()
                        .dataSource(url, user, password)
        );
    }

}
