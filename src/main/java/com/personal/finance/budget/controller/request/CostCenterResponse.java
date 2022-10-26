package com.personal.finance.budget.controller.request;

import com.personal.finance.budget.controller.response.AccountResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CostCenterResponse {

    private UUID id;

    private String name;

    private String description;

    private List<AccountResponse> accountsResponse;

}
