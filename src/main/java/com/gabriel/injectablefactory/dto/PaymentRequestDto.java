package com.gabriel.injectablefactory.dto;

import com.gabriel.injectablefactory.payment.enums.PaymentMethod;

import java.math.BigDecimal;

public class PaymentRequestDto {
    public BigDecimal amount;
    public PaymentMethod paymentMethod;
}
