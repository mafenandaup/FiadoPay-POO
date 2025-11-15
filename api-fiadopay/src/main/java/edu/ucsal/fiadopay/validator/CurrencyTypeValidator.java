package edu.ucsal.fiadopay.validator;

import edu.ucsal.fiadopay.annotations.CurrencyType;
import edu.ucsal.fiadopay.annotations.PaymentMethod;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CurrencyTypeValidator implements ConstraintValidator<CurrencyType, String> {
    @Override
    public void initialize(CurrencyType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
