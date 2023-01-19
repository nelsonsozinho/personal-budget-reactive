package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.Budget;
import com.personal.finance.budget.model.query.BudgetPaymentTotal;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface BudgetRepository  extends ReactiveCrudRepository<Budget, String> {

    @Query("select budget.* \n" +
           "from budget \n" +
           "where budget.user_id = :userId")
    Flux<Budget> findBudgetsByUserUserId(UUID userId);

    @Query("select budget.budget_id, budget.name, budget.description, budget.total, sum(payment.value) payment_total\n" +
            "from budget, budget_user bu, cost_center cc\n" +
            "inner join bill_cost_center as acc on acc.bill_id = acc.bill_id and acc.cost_center_id = cc.cost_center_id\n" +
            "inner join bill on bill.bill_id = acc.bill_id\n" +
            "inner join payment on payment.bill_id = bill.bill_id\n" +
            "where bu.user_id = :userId\n" +
            "and budget.user_id = bu.user_id\n" +
            "and cc.budget_id = budget.budget_id\n" +
            "and cc.budget_id = budget.budget_id\n" +
            "group by budget.budget_id, budget.name, budget.description, budget.total")
    Flux<BudgetPaymentTotal> listBudgetsByUserWithTotalPayment(@Param("userId") UUID userId);

}
