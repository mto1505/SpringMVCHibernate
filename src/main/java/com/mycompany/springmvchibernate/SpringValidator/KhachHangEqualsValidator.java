package com.mycompany.springmvchibernate.SpringValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springmvchibernate.AnnotationValidator.PhoneValid;
import com.mycompany.springmvchibernate.BeanValidator.PhoneValidator;
import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
//@Component
public class KhachHangEqualsValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
	return KhachHangDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		KhachHangDTO khachHangDTO=(KhachHangDTO) target;
		
		//kiểm tra số điện thoại
		if(errors.hasFieldErrors("taiKhoan.password"))
		{
			return; //nếu lỗi xảy ra ở password thì không cần kiểm tra validator này
		}
		String password=khachHangDTO.getTaiKhoan().getPassword();
		String confirmPassword=khachHangDTO.getTaiKhoan().getPasswordConfirm();
		if(!password.equals(confirmPassword))
		{
			errors.rejectValue("taiKhoan.password","PasswordEqualsValidator.khachHangDTO.password","Mật khẩu nhập lại không khớp");
		}	
	}

}
