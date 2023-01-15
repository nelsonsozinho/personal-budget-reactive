package com.personal.finance.budget.controller;

import com.personal.finance.budget.controller.response.PaymentResponse;
import com.personal.finance.budget.service.PaymentService;
import com.personal.finance.budget.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    private final UserService userService;

//    @PostMapping("/account/{accountId}")
//    public Mono<String> newPayment(
//            @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
//            @RequestBody PaymentRequest request,
//            @PathVariable UUID accountId) {
//
//        userService.finAuthUser(token)
//                .flatMap(user -> {
//                    paymentService.saveNewPayment()
//                })
//
//        return Mono.just("");
//    }

    @GetMapping("/account/{accountId}")
    public Flux<PaymentResponse> listPaymentsByAccount(@PathVariable UUID accountId) {
        return paymentService.findPaymentsByAccount(accountId);
    }

}
