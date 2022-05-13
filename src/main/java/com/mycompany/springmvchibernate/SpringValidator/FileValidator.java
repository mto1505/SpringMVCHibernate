package com.mycompany.springmvchibernate.SpringValidator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidator implements Validator {
	public static final String PNG_MIME_TYPE="image/png";
	@Value("{maxUploadSize}")
	public static long TEN_MB_IN_BYTES;
	    @Override
	    public boolean supports(Class<?> clazz) {
	        return MultipartFile.class.isAssignableFrom(clazz);
	    }
	 
	    @Override
	    public void validate(Object target, Errors errors) {
	      
	        MultipartFile file = (MultipartFile) target;
	        if(file.isEmpty()){
	            errors.rejectValue("file", "upload.file.required");
	        }
	       /* else if(!PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType())){
	            errors.rejectValue("file", "upload.invalid.file.type");
	        }*/
	       
	        else if(file.getSize() > 1){
	            errors.rejectValue("file", "upload.exceeded.file.size");
	        }
	       
	    }
	
	
}
