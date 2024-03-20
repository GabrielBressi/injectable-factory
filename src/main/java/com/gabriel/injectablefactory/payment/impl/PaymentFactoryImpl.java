package com.gabriel.injectablefactory.payment.impl;

import com.gabriel.injectablefactory.payment.PaymentFactory;
import com.gabriel.injectablefactory.payment.PaymentService;
import com.gabriel.injectablefactory.payment.enums.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class PaymentFactoryImpl implements PaymentFactory {


    private final List<PaymentService> concretePaymentServices;

    @Autowired
    public PaymentFactoryImpl(
            List<PaymentService> concretePaymentServices) {
        this.concretePaymentServices = concretePaymentServices;
    }

    @Override
    public PaymentService create(PaymentMethod paymentMethod) throws ClassNotFoundException {
        switch (paymentMethod) {
            case CREDIT_CARD -> {
                return getPaymentService(CreditCardPaymentService.class);
            }
            case PAYPAL -> {
                return getPaymentService(PayPalPaymentService.class);
            }
            case GOOGLE_PAY -> {
                return getPaymentService(GooglePayPaymentService.class);
            }
            default -> {
                throw new ClassNotFoundException(MessageFormat.format(
                        "{0} is not currently supported as a payment method.", paymentMethod
                ));
            }
        }

    }

    private PaymentService getPaymentService(Class type) {
        return (PaymentService) concretePaymentServices.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findFirst()
                .orElse(null);
    }

}
