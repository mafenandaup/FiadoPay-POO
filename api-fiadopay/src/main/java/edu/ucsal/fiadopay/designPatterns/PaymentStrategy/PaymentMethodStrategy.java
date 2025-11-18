package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

import java.math.BigDecimal;

public interface PaymentMethodStrategy {
    void pay(BigDecimal amount);

    boolean supports(String method);

    BigDecimal calculateTotal(BigDecimal amount, Integer installments);

}

