package com.mycompany.springmvchibernate.BeanValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.springmvchibernate.AnnotationValidator.UploadFileImageMaxSize;

@Component
public class UploadFileMaxSizeValidator implements ConstraintValidator<UploadFileImageMaxSize,MultipartFile>{

	private UploadFileImageMaxSize constraint;
	@Override
	public void initialize(UploadFileImageMaxSize constraintAnnotation) {
		// TODO Auto-generated method stub
		this.constraint=constraintAnnotation;
	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		 if (constraint.value() < 0 || multipartFile == null) {
	            return true;
	        }
	        return multipartFile.getSize() <= constraint.value();
	}

}
