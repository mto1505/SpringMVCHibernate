package com.mycompany.springmvchibernate.BeanValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.mycompany.springmvchibernate.AnnotationValidator.PasswordMatches;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
	
	public String field;

    private String confirmField;

    private String message;
    
	   @Override
	    public void initialize(PasswordMatches constraintAnnotation) {
		   field=constraintAnnotation.field();
		   confirmField = field+"Confirm"; //StringUtils.capitalize(field)
	        message = constraintAnnotation.message();
		  
	    }
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		BeanWrapper beanWrapper = new BeanWrapperImpl(value); // (1)	
        Object fieldValue = beanWrapper.getPropertyValue(field); // (2)
        Object confirmFieldValue = beanWrapper.getPropertyValue(confirmField);
       
        boolean matched = ObjectUtils.nullSafeEquals(fieldValue,
                confirmFieldValue);
        if (matched) {
            return true;
        } else {
            context.disableDefaultConstraintViolation(); // (3)
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(confirmField).addConstraintViolation(); // (4)
            return false;
        }
    }

}
