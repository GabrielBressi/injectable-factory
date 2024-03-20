package com.gabriel.injectablefactory.payment.controllers;

import com.gabriel.injectablefactory.dto.PaymentRequestDto;
import com.gabriel.injectablefactory.payment.PaymentFactory;
import com.gabriel.injectablefactory.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/payments")
public class PaymentController {

    private final PaymentFactory paymentFactory;

    @Autowired
    public PaymentController(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    @PostMapping(path = "/makePayment")
    public ResponseEntity<String> pay(@RequestBody PaymentRequestDto paymentRequestDto) {
        try {
            PaymentService paymentService = paymentFactory.create(paymentRequestDto.paymentMethod);
            return ResponseEntity.ok().body(paymentService.pay(paymentRequestDto.amount));
        } catch (ClassNotFoundException e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
