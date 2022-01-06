package com.tavo.form.formexample.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequeridoValidador implements ConstraintValidator<Requerido,String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       /*  if(value.isBlank() || value.isEmpty() || value.equals(null)){
            return false;
        } primera forma sin usar utileria de spring*/

        if(value.equals(null) || !StringUtils.hasText(value)){
            return false;
        }
        return true;
    }
    
}
