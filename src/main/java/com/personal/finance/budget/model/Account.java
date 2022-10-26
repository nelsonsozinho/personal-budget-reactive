package com.personal.finance.budget.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table("account")
public class Account {

    @Id
    @Column("account_id")
    private UUID id;

    private String name;

    private Double value;

    private String description;

    @Column("variable")
    private Boolean isVariable;

    private List<CostCenter> costCenters;

}
