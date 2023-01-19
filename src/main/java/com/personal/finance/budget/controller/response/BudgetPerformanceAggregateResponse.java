package com.personal.finance.budget.controller.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BudgetPerformanceAggregateResponse {

    private List<BudgetPerformanceResponse> budgetPerformanceResponses;

    private Double totalPayments;

}
