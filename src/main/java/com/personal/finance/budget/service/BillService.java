package com.personal.finance.budget.service;

import com.personal.finance.budget.controller.response.AccountResponse;
import com.personal.finance.budget.mapper.BillMapper;
import com.personal.finance.budget.model.Bill;
import com.personal.finance.budget.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    private final BillMapper billMapper;

    public Flux<Bill> listBills() {
        return billRepository.findAll();
    }

    public Flux<AccountResponse> listBillsByCostCenter(UUID costCenterId) {
        return billRepository.findByCostCentersId(costCenterId)
                .map(billMapper::toBillResponse);
    }

    public Flux<AccountResponse> listBillsByBudget(UUID budgetId) {
        return billRepository.findByBudgetId(budgetId)
                .map(billMapper::toBillResponse);
    }

}
