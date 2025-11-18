package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

import java.math.BigDecimal;

public class PixStrategy implements PaymentMethodStrategy {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("PAGO COM PIX: " + amount);
    }

    @Override
    public boolean supports(String method) {
        return MethodsList.PIX.name().equalsIgnoreCase(method);
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal amount, Integer installments) {
        return amount;
    }
}

