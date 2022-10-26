package com.personal.finance.budget.mapper;

import com.personal.finance.budget.controller.response.AccountResponse;
import com.personal.finance.budget.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "variable", target = "isVariable")
    AccountResponse toAccountResponse(Account account);

}
