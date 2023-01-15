package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.Bill;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface BillRepository extends ReactiveCrudRepository<Bill, String> {

    @Query("select a.* \n" +
            "from bill a \n" +
            "inner join account_cost_center acc on a.account_id = acc.account_id \n" +
            "inner join cost_center cc on acc.cost_center_id = cc.cost_center_id \n" +
            "and cc.cost_center_id = :costCenterId")
    Flux<Bill> findByCostCentersId(UUID costCenterId);

    @Query("select a.*\n" +
            "from bill a\n" +
            "inner join account_cost_center acc on a.account_id = acc.account_id\n" +
            "inner join cost_center cc on acc.cost_center_id = cc.cost_center_id\n" +
            "inner join budget b on cc.budget_id = b.budget_id\n" +
            "and b.budget_id = :budgetId")
    Flux<Bill> findByBudgetId(UUID budgetId);

}
