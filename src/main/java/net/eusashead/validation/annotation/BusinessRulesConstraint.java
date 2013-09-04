package net.eusashead.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import net.eusashead.validation.validator.BusinessRulesConstraintValidator;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=BusinessRulesConstraintValidator.class)
  
public @interface BusinessRulesConstraint {
 String message() default "Business rules validation failed.";
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
}