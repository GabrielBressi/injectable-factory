package com.gabriel.injectablefactory.payment;

import java.math.BigDecimal;

public interface PaymentService {

    String pay(BigDecimal amount);

}
