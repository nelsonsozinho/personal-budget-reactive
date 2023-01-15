package com.personal.finance.budget.mapper;

import com.personal.finance.budget.controller.response.AccountResponse;
import com.personal.finance.budget.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BillMapper {

    @Mapping(source = "variable", target = "isVariable")
    AccountResponse toBillResponse(Bill account);

}
