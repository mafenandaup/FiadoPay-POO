package edu.ucsal.fiadopay.annotations;

import edu.ucsal.fiadopay.validator.PaymentMethodValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD}) // aqui indica que só pode ser usada nos campos "mencionados" nas entities
@Constraint(validatedBy = PaymentMethodValidator.class)
public @interface PaymentMethod {

    String message() default "Método de pagamento inválido. Permitidos: PIX, BOLETO, CARTAO, DEBIT."; //msg de erro

    public enum Methods
    {PIX, BOLETO, CARTAO, DEBIT}

}
