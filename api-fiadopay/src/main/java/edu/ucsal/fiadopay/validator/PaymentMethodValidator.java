// ARQUIVO: PaymentMethodValidator.java
package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.PaymentMethod;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PaymentMethodValidator implements ConstraintValidator<PaymentMethod, String> {

    private static final Set<String> METODOS = Set.of("CARD", "PIX", "DEBIT", "BOLETO");

    @Override
    public boolean isValid(String method, ConstraintValidatorContext constraintValidatorContext) {
        if (method == null) {
            return false;
        }

        return METODOS.contains(method.toUpperCase());
    }
}