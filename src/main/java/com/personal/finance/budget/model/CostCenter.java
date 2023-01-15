package com.personal.finance.budget.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table("cost_center")
public class CostCenter {

    @Id
    @Column("cost_center_id")
    private UUID id;

    private String name;

    private String description;

    private List<Bill> accounts;

    private Budget budget;

}
