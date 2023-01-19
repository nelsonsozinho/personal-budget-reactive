package com.personal.finance.budget.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private UUID id;

    private String name;

    private Double value;

    private String description;

    private Boolean isVariable;
}
