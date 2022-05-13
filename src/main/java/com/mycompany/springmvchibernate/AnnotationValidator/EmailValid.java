package com.mycompany.springmvchibernate.AnnotationValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.BeanValidator.EmailValidator;
import com.mycompany.springmvchibernate.BeanValidator.PhoneValidator;

@Component
@Retention(RUNTIME)
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Constraint(validatedBy= EmailValidator.class)
public @interface EmailValid {

	String message() default "{com.mycompany.springmvchibernate.AnnotationValidator.EmailValid.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	

	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
		EmailValid[] value();
    }
}
