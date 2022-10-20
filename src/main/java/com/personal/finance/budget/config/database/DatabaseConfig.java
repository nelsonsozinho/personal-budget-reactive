package com.personal.finance.budget.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Handles;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;


import javax.sql.DataSource;
import java.util.concurrent.Executors;

//@Configuration
public class DatabaseConfig {

    private final String url;
    private final String username;
    private final String password;
    private final Integer maximumPoolSize;

    public DatabaseConfig(@Value("${spring.datasource.url}") final String url,
                          @Value("${spring.datasource.username}") final String username,
                          @Value("${spring.datasource.password}") final String password,
                          @Value("${spring.datasource.hikari.maximumPoolSize}") final Integer maximumPoolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maximumPoolSize = maximumPoolSize;
    }

    @Bean
    public DataSource dataSource() {
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl(this.url);
        config.setUsername(this.username);
        config.setPassword(this.password);
        config.setMaximumPoolSize(this.maximumPoolSize);

        return new HikariDataSource(config);
    }

    @Bean
    public Jdbi jdbi(final DataSource dataSource) {
        final Jdbi jdbi = Jdbi.create(dataSource);
        jdbi.getConfig(Handles.class).setForceEndTransactions(false);
        jdbi.setSqlLogger(new DefaultSqlLogger());

        return jdbi;
    }

    @Bean
    public Scheduler jdbcScheduler() {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(this.maximumPoolSize));
    }

}
