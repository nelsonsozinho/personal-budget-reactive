package com.personal.finance.budget.mapper;

import com.personal.finance.budget.controller.request.BudgetRequest;
import com.personal.finance.budget.controller.response.BudgetResponse;
import com.personal.finance.budget.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    @Mapping(target = "accounts", ignore = true)
    BudgetResponse toBudgetResponse(Budget budget);

    Budget toBudget(BudgetRequest budgetRequest);

}
