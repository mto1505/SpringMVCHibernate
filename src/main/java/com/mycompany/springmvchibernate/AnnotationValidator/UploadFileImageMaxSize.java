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

import com.mycompany.springmvchibernate.BeanValidator.UploadFileMaxSizeValidator;
@Component
@Retention(RUNTIME)
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Constraint(validatedBy= UploadFileMaxSizeValidator.class)
public @interface UploadFileImageMaxSize {
	String message() default "{com.mycompany.springmvchibernate.AnnotationValidator.UploadFileImageMaxSize.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	long value() default (1024*200);//1mb
	
	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
		UploadFileImageMaxSize[] value();
    }


 }
