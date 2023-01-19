package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.response.BudgetPerformanceAggregateResponse;
import com.personal.finance.budget.controller.response.BudgetResponse;
import com.personal.finance.budget.service.BudgetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/budget")
@AllArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/list")
    public Flux<BudgetResponse> listBudgets() {
        return budgetService.listAllBudget();
    }

    @GetMapping("/{userId}")
    public Flux<BudgetResponse> findBudgetsByUser(@PathVariable("userId") UUID userId) {
        return budgetService.findBudgetsByUser(userId);
    }

    @GetMapping("/{budgetId}/performance")
    public Mono<BudgetPerformanceAggregateResponse> getBudgetPerformance(@PathVariable("budgetId") UUID budgetId) {
        return budgetService.findBudgetPerformance(budgetId);
    }

    @GetMapping("/{userId}/payments")
    public Flux<BudgetResponse> getBudgetsWithPaymentTotal(@PathVariable("userId") UUID userId) {
        return budgetService.findBudgetByUserWithTotalPayment(userId);
    }

}
