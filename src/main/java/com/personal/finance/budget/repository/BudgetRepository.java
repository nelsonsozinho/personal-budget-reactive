package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.Budget;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BudgetRepository  extends ReactiveCrudRepository<Budget, String> {

}
