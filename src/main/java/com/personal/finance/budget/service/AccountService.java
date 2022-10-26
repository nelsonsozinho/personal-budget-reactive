package com.personal.finance.budget.service;

import com.personal.finance.budget.model.Account;
import com.personal.finance.budget.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    public Flux<Account> listAccount() {
        return accountRepository.findAll();
    }

    public Flux<Account> listAccountByCostCenter(UUID costCenterId) {
        return accountRepository.findByCostCentersId(costCenterId);
    }

    public Flux<Account> listAccountByBudget(UUID budgetId) {
        return accountRepository.findByBudgetId(budgetId);
    }

}
