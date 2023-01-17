package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.request.PaymentRequest;
import com.personal.finance.budget.controller.response.PaymentResponse;
import com.personal.finance.budget.service.PaymentService;
import com.personal.finance.budget.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    private final UserService userService;

    @PostMapping()
    public Mono<PaymentResponse> newPayment(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
            @RequestBody PaymentRequest request) {

        return userService.finAuthUser(token)
                .flatMap(user -> paymentService.saveNewPayment(request));
    }

    @GetMapping("/account/{accountId}")
    public Flux<PaymentResponse> listPaymentsByAccount(@PathVariable UUID accountId) {
        return paymentService.findPaymentsByAccount(accountId);
    }

}
