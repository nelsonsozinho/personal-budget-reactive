package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.response.AccountResponse;
import com.personal.finance.budget.model.Bill;
import com.personal.finance.budget.service.BillService;
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

    private BillService accountService;

    @GetMapping
    public Flux<Bill> listAllAccount() {
        return accountService.listBills();
    }

    @GetMapping("/cost-center/{id}")
    public Flux<AccountResponse> listAccountsByCostCenter(@PathVariable("id") UUID costCenterId) {
        return accountService.listBillsByCostCenter(costCenterId);
    }

    @GetMapping("/budget/{id}")
    public Flux<AccountResponse> listAccountsByBudget(@PathVariable("id") UUID budgetId) {
        return accountService.listBillsByBudget(budgetId);
    }

}
