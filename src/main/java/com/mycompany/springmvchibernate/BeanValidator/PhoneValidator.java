package com.mycompany.springmvchibernate.BeanValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.springmvchibernate.AnnotationValidator.PhoneValid;
import com.mycompany.springmvchibernate.AnnotationValidator.UploadFileImageMaxSize;


@Component
public class PhoneValidator implements ConstraintValidator<PhoneValid,String>{
	private Pattern pattern;
	private Matcher matcher;
	//private static final String phoneRegex="^(84|0[3|5|7|8|9])+([0-9]{8})\\b";
	private PhoneValid constraint;
	
	public void initialize(PhoneValid constraintAnnotation) {
		// TODO Auto-generated method stub
		this.constraint=constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		pattern=Pattern.compile(constraint.phoneRegex());
		matcher=pattern.matcher(value);
		return matcher.matches();
		
	}

}
