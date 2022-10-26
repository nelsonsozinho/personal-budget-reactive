package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.response.AccountResponse;
import com.personal.finance.budget.model.Account;
import com.personal.finance.budget.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @GetMapping
    public Flux<Account> listAllAccount() {
        return accountService.listAccount();
    }

    @GetMapping("/cost-center/{id}")
    public Flux<AccountResponse> listAccountsByCostCenter(@PathVariable("id") UUID costCenterId) {
        return accountService.listAccountByCostCenter(costCenterId);
    }

    @GetMapping("/budget/{id}")
    public Flux<AccountResponse> listAccountsByBudget(@PathVariable("id") UUID budgetId) {
        return accountService.listAccountByBudget(budgetId);
    }

}
