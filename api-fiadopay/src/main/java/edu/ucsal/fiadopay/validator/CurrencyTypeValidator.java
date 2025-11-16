package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.CurrencyType;
import edu.ucsal.fiadopay.annotations.PaymentMethod;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Currency;

public class CurrencyTypeValidator implements ConstraintValidator<CurrencyType, String> {

    @Override
    public boolean isValid(String moeda, ConstraintValidatorContext constraintValidatorContext) {
        if (moeda == null || moeda.trim().isEmpty()) {
            return false;
        }
        try {
            Currency.getInstance(moeda.toUpperCase()); // usa a classe própria do java p validar os tipos de moeda válidos
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
