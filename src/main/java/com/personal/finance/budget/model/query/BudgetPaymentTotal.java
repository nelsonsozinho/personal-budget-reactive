package com.personal.finance.budget.model.query;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Data
public class BudgetPaymentTotal {

    @Column("budget_id")
    private UUID id;

    @Column("total")
    private Double total;

    @Column("payment_total")
    private Double paymentTotal;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

}
