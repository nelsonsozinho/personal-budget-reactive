package com.personal.finance.budget.model.query;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class BudgetPerformance {

    @Column("costCenterName")
    private String costCenterName;
    @Column("billName")
    private String billName;
    @Column("paymentValues")
    private Double paymentValues;

}
