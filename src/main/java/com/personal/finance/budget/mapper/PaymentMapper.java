package com.personal.finance.budget.mapper;

import com.personal.finance.budget.controller.request.PaymentRequest;
import com.personal.finance.budget.controller.response.PaymentResponse;
import com.personal.finance.budget.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse toPaymentResponse(Payment payment);

    Payment toPayment(PaymentRequest request);

}
