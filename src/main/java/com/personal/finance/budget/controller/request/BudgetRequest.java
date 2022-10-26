package com.personal.finance.budget.controller.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BudgetRequest {

    private UUID id;

    private Double total;

    private String name;

    private String description;

}
