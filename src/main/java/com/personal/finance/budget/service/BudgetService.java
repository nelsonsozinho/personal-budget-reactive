package com.personal.finance.budget.service;

import com.personal.finance.budget.controller.request.BudgetRequest;
import com.personal.finance.budget.controller.response.BudgetPerformanceAggregateResponse;
import com.personal.finance.budget.controller.response.BudgetPerformanceResponse;
import com.personal.finance.budget.controller.response.BudgetResponse;
import com.personal.finance.budget.mapper.BudgetMapper;
import com.personal.finance.budget.repository.BudgetRepository;
import com.personal.finance.budget.repository.report.BudgetRepositoryPerformanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    private final BudgetRepositoryPerformanceRepository budgetRepositoryPerformance;

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
    public Flux<BudgetResponse> findBudgetByUserWithTotalPayment(final UUID userId) {
        return this.budgetRepository.listBudgetsByUserWithTotalPayment(userId)
                .map(budgetMapper::toBudgetPerformanceResponse);
    }


    public Mono<BudgetPerformanceAggregateResponse> findBudgetPerformance(UUID budgetId) {
        final var list = budgetRepositoryPerformance.getBudgetPerformance(budgetId).collectList().block();

        return Mono.just(BudgetPerformanceAggregateResponse.builder())
                .map(builder -> {
                    var listConverter = list.stream().map(element ->
                            BudgetPerformanceResponse.builder()
                                    .billName(element.getBillName())
                                    .paymentValues(element.getPaymentValues())
                                    .costCenterName(element.getCostCenterName())
                                    .build())
                            .collect(Collectors.toList());

                    return builder.budgetPerformanceResponses(listConverter)
                            .totalPayments(listConverter.stream().map(BudgetPerformanceResponse::getPaymentValues).reduce(0.0D, Double::sum))
                            .build();
                });
    }

}
