package com.personal.finance.budget.service;

import com.personal.finance.budget.controller.request.BudgetRequest;
import com.personal.finance.budget.controller.response.BudgetResponse;
import com.personal.finance.budget.mapper.BudgetMapper;
import com.personal.finance.budget.repository.BudgetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    private final BudgetMapper budgetMapper;

    public Mono<BudgetResponse> saveBudget(BudgetRequest budgetRequest) {
        return Mono.just(budgetMapper.toBudget(budgetRequest))
                .flatMap(budgetRepository::save)
                .map(budgetMapper::toBudgetResponse);
    }

    public Flux<BudgetResponse> listAllBudget() {
        return budgetRepository.findAll()
                .map(budgetMapper::toBudgetResponse);
    }

    public Flux<BudgetResponse> findBudgetsByUser(UUID userId) {
        return budgetRepository.findBudgetsByUserUserId(userId)
                .map(budgetMapper::toBudgetResponse);
    }

}
