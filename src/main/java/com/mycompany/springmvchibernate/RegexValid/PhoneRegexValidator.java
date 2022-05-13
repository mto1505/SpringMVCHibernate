package com.mycompany.springmvchibernate.RegexValid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mycompany.springmvchibernate.AnnotationValidator.PhoneValid;

public class PhoneRegexValidator {
	private Pattern pattern;
	private Matcher matcher;
	private static final String phoneRegex="^(84|0[3|5|7|8|9])+([0-9]{8})\\b";
	
	public boolean isValid(String phone)
	{
		pattern=Pattern.compile(phoneRegex);
		matcher=pattern.matcher(phone);
		return matcher.matches();
		
	}
	
}
