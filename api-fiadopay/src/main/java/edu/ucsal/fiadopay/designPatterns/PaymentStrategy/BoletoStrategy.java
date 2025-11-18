package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

import java.math.BigDecimal;

public class BoletoStrategy implements PaymentMethodStrategy{

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("PAGO COM BOLETO: " +amount);
    }

    @Override
    public boolean supports(String method) {
        return MethodsList.BOLETO.name().equalsIgnoreCase(method); // nome inserido é compatível com o tipo no enum?? se sim ok
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal amount, Integer installments) {
        return amount;
    }
}
