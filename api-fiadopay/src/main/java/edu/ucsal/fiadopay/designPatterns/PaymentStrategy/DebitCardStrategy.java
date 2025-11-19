package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DebitCardStrategy implements PaymentMethodStrategy{

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("PAGO COM CARTÃO DE DÉBITO: " +amount);
    }


    @Override
    public boolean supports(String method) {
        return MethodsList.DEBITO.name().equalsIgnoreCase(method);
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal amount, Integer installments) {
        return amount;
    }
}
