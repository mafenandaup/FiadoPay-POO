package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditCardStrategy implements PaymentMethodStrategy{

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("PAGO COM CARTÃO DE CRÉDITO: " + amount);
    }

    @Override
    public boolean supports(String method) {
        return MethodsList.CREDITO.name().equalsIgnoreCase(method);
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal amount, Integer installments) {
        if (installments == null || installments <= 1) {
            return amount;
        }
        BigDecimal juros = new BigDecimal("1.05");
        return amount.multiply(juros);
    }
}