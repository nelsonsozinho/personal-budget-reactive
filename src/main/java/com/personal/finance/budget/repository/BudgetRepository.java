package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.Budget;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface BudgetRepository  extends ReactiveCrudRepository<Budget, String> {

    @Query("select budget.* \n" +
           "from budget \n" +
           "where budget.user_id = :userId")
    Flux<Budget> findBudgetsByUserUserId(UUID userId);

}
