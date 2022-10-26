package com.personal.finance.budget.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table("budget")
public class Budget {

    @Id
    @Column("budget_id")
    private UUID id;

    private Double total;

    private String name;

    private String description;

    private List<CostCenter> costCenters;

    private User user;

}
