package com.personal.finance.budget.repository.report;

import com.personal.finance.budget.model.query.BudgetPerformance;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface BudgetRepositoryPerformanceRepository extends ReactiveCrudRepository<BudgetPerformance, UUID> {

    @Query("select cc.name costCenterName, bill.name billName, sum(payment.value) paymentValues \n" +
            "from budget, cost_center cc \n" +
            "inner join bill_cost_center as acc on acc.bill_id = acc.bill_id and acc.cost_center_id = cc.cost_center_id \n" +
            "inner join bill on bill.bill_id = acc.bill_id \n" +
            "inner join payment on payment.bill_id = bill.bill_id \n" +
            "where budget.budget_id = :budgetId \n" +
            "and budget.budget_id = cc.budget_id \n" +
            "and cc.budget_id = budget.budget_id \n" +
            "group by cc.name, bill.name")
    Flux<BudgetPerformance> getBudgetPerformance(@Param("budgetId") UUID budgetId);

}
