package com.mycompany.springmvchibernate.AnnotationValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
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

import com.mycompany.springmvchibernate.BeanValidator.PasswordMatchesValidator;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {
	 	String message() default "Mật khẩu không khớp";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	    
	    String field(); // (2)Define parameter to pass to annotation.
	    
		@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
	    @Retention(RetentionPolicy.RUNTIME)
	    @Documented
	    @interface List {
			PasswordMatches[] value();
	    }
}
