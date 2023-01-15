package com.personal.finance.budget.controller.request;

import lombok.Data;

import java.util.UUID;

@Data
public class PaymentRequest {

    private Double value;
    private String description;

    private UUID accountId;

}
