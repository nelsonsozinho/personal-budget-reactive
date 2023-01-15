package com.personal.finance.budget.repository;

import com.personal.finance.budget.model.Payment;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface PaymentRepository extends ReactiveCrudRepository<Payment, UUID> {

    @Query("select payment.* \n" +
            "from payment \n" +
            "where payment.account_id = :accountId")
    Flux<Payment> listPaymentsByAccount(UUID accountId);


}
