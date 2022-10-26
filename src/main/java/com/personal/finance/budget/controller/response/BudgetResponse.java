package com.personal.finance.budget.controller.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BudgetResponse {

    private UUID id;

    private Double total;

    private String name;

    private String description;

    private List<AccountResponse> accounts;
}
