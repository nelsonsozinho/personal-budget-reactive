package com.personal.finance.budget.service;

import com.personal.finance.budget.controller.response.PaymentResponse;
import com.personal.finance.budget.mapper.PaymentMapper;
import com.personal.finance.budget.repository.BillRepository;
import com.personal.finance.budget.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final BillRepository accountRepository;

    private final PaymentMapper paymentMapper;

    public Flux<PaymentResponse> findPaymentsByAccount(final UUID accountId) {
        return paymentRepository.listPaymentsByAccount(accountId)
                .map(payment -> paymentMapper.toPaymentResponse(payment));
    }

//    public Mono<PaymentResponse> saveNewPayment(PaymentRequest request) {
//        return Mono.just(Payment.builder())
//                .map(builder ->
//                        builder.value(request.getValue())
//                                .date(LocalDateTime.now())
//                                .description(request.getDescription())
//                                .account(Account.builder().id(request.getAccountId()).build())
//                                .build()
//                )
//                .flatMap(paymentRepository::save)
//                .map(paymentMapper::toPaymentResponse);
//    }

}
