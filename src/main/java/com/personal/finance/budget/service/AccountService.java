package com.personal.finance.budget.service;

import com.personal.finance.budget.controller.response.AccountResponse;
import com.personal.finance.budget.mapper.AccountMapper;
import com.personal.finance.budget.model.Account;
import com.personal.finance.budget.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public Flux<Account> listAccount() {
        return accountRepository.findAll();
    }

    public Flux<AccountResponse> listAccountByCostCenter(UUID costCenterId) {
        return accountRepository.findByCostCentersId(costCenterId)
                .map(accountMapper::toAccountResponse);
    }

    public Flux<AccountResponse> listAccountByBudget(UUID budgetId) {
        return accountRepository.findByBudgetId(budgetId)
                .map(accountMapper::toAccountResponse);
    }

}
