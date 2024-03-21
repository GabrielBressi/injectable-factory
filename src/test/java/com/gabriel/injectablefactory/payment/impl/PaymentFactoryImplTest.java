package com.gabriel.injectablefactory.payment.impl;

import com.gabriel.injectablefactory.payment.PaymentService;
import com.gabriel.injectablefactory.payment.enums.PaymentMethod;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentFactoryImplTest {

    @Test
    @DisplayName("Must return the correct payment service")
    public void createCase01() {
        PaymentFactoryImpl paymentFactory = new PaymentFactoryImpl(Arrays.asList(
                new CreditCardPaymentService(),
                new PayPalPaymentService(),
                new GooglePayPaymentService()
        ));

        try {
            PaymentService paymentService = paymentFactory.create(PaymentMethod.CREDIT_CARD);
            assertInstanceOf(CreditCardPaymentService.class, paymentService);
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should be thrown");
        }

        try {
            PaymentService paymentService = paymentFactory.create(PaymentMethod.PAYPAL);
            assertInstanceOf(PayPalPaymentService.class, paymentService);
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should be thrown");
        }

        try {
            PaymentService paymentService = paymentFactory.create(PaymentMethod.GOOGLE_PAY);
            assertInstanceOf(GooglePayPaymentService.class, paymentService);
        } catch (ClassNotFoundException e) {
            fail("ClassNotFoundException should be thrown");
        }
    }

    @Test
    @DisplayName("Must throws ClassNotFoundException")
    public void createCase02() {
        PaymentFactoryImpl paymentFactory = new PaymentFactoryImpl(Arrays.asList(
                new CreditCardPaymentService(),
                new PayPalPaymentService(),
                new GooglePayPaymentService()
        ));

        try {
            paymentFactory.create(PaymentMethod.PAYMENT_METHOD_NOT_SUPPORTED);
            fail("ClassNotFoundException should be thrown");
        } catch (ClassNotFoundException e) {
            assertEquals("PAYMENT_METHOD_NOT_SUPPORTED is not currently supported as a payment method.", e.getMessage());
        }
    }

}