package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

    @Query("select buser.*\n " +
            "from budget_user buser\n " +
            "where buser.email = :email\n ")
    Mono<User> findByEmail(String email);

}
