package com.personal.finance.budget.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PaymentResponse {

    private UUID id;

    private Double value;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime date;

}
