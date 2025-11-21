package edu.ucsal.fiadopay.designPatterns.PaymentStrategy;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class PaymentProcessor {

    private List<PaymentMethodStrategy> strategyList;

    public PaymentProcessor(List<PaymentMethodStrategy> strategyList) {
        this.strategyList = strategyList;
    }

    private PaymentMethodStrategy findStrategy(String method) {
        Optional<PaymentMethodStrategy> strategy = strategyList.stream() //percorre a lista até achar um que suporte a string q a gente inseriu
                .filter(s -> s.supports(method))
                .findFirst();

        if (strategy.isEmpty()) {
            throw new IllegalArgumentException("O método de pagamento '" + method + "' não é suportado.Tente novamente.");
        }
        return strategy.get();
    }

    public BigDecimal pay(String method, BigDecimal amount, Integer installments) {
        PaymentMethodStrategy strategy = findStrategy(method);
        BigDecimal finalAmount = strategy.calculateTotal(amount, installments); //calculamos o total conforme o método escolhido antes de pagar

        strategy.pay(finalAmount);

        return finalAmount;
    }
}