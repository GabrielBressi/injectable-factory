package com.gabriel.injectablefactory.payment;

import com.gabriel.injectablefactory.payment.PaymentService;
import com.gabriel.injectablefactory.payment.enums.PaymentMethod;

public interface PaymentFactory {

    PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException;

}
