package com.dev.validation;

import com.dev.validation.constraintvalidation.NotEmptyListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Para ser verificada em tempo de execução
@Target(ElementType.FIELD) //Diz onde a annotation deve ser colocada(FILD: em cima de um campo)
@Constraint(validatedBy = NotEmptyListValidator.class) //Indica que essa é uma annotation de validação
public @interface NotEmptyList {
    String message() default "A lista não pode ser vazia!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
