package com.personal.finance.budget.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BudgetResponse {

    private UUID id;

    private Double total;

    private Double paymentTotal;

    private String name;

    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AccountResponse> accounts;
}
