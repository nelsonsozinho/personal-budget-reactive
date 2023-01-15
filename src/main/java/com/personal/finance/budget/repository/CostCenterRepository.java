package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.CostCenter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CostCenterRepository extends ReactiveCrudRepository<CostCenter, String> {

    Flux<CostCenter> getCostCentersByBudgetId(UUID budgetId);

}
