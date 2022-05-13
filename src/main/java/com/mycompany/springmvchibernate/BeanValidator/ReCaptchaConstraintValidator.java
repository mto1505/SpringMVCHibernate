package com.mycompany.springmvchibernate.BeanValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.springmvchibernate.AnnotationValidator.ValidReCaptcha;
import com.mycompany.springmvchibernate.Service.Impl.ReCatpchaService;

public class ReCaptchaConstraintValidator implements ConstraintValidator<ValidReCaptcha, String> {
	
	@Autowired(required=false)
    private ReCatpchaService reCaptchaService;

    @Override
    public void initialize(ValidReCaptcha constraintAnnotation) {

    }

    @Override
    public boolean isValid(String reCaptchaResponse, ConstraintValidatorContext context) {

        if (reCaptchaResponse == null || reCaptchaResponse.isEmpty()){
            return true;
        }

        return reCaptchaService.validate(reCaptchaResponse);
    }
}
