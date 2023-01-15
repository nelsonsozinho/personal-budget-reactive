package com.personal.finance.budget.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table("account")
@Builder
public class Bill {

    @Id
    @Column("account_id")
    private UUID id;

    private String name;

    private Double value;

    private String description;

    @Column("variable")
    private Boolean isVariable;

    private List<CostCenter> costCenters;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVariable() {
        return isVariable;
    }

    public void setVariable(Boolean variable) {
        isVariable = variable;
    }

    public List<CostCenter> getCostCenters() {
        return costCenters;
    }

    public void setCostCenters(List<CostCenter> costCenters) {
        this.costCenters = costCenters;
    }
}
