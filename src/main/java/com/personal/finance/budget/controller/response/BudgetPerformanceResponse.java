package com.personal.finance.budget.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BudgetPerformanceResponse {
    private String costCenterName;
    private String billName;
    private Double paymentValues;

}
