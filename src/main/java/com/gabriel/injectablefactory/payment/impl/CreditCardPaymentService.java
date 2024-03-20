package com.gabriel.injectablefactory.payment.impl;

import com.gabriel.injectablefactory.payment.PaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;

@Service
public class CreditCardPaymentService implements PaymentService {

    @Override
    public String pay(BigDecimal amount) {
       return MessageFormat.format("Successfully paid ${0} to merchant using a Credit Card", amount);
    }

}
