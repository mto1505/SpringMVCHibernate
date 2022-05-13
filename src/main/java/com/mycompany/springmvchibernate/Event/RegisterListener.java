package com.mycompany.springmvchibernate.Event;

import java.util.Locale;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import com.mycompany.springmvchibernate.Service.IVerificationTokenService;

@Component
public class RegisterListener implements ApplicationListener<OnRegistrationCompleteEvent>{
	
	@Autowired
	private IKhachHangService khachHangService;
	@Autowired
	private IVerificationTokenService verificationService;
	@Autowired
	private MessageSource messageSource;
	@Autowired(required=false)
	private JavaMailSender javaMail;
	
	  @Autowired
	    private Environment env;

	  
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		// TODO Auto-generated method stub
		confirmRegistration(event);
		
	}
	public void confirmRegistration(OnRegistrationCompleteEvent event)
	{
		KhachHang khachHang=event.getKhachHang();
		Locale locale=event.getLocale();
		String appUrl=event.getAppUrl();
		
		String token=UUID.randomUUID().toString();
		
		verificationService.createVerificationToken(khachHang, token);
		
		String recipientAddress =khachHang.getEmail();
		String subject="Hoàn tất đăng kí";
		String confirmationUrl=appUrl+"/registrationConfirm?token="+ token;
		String message=messageSource.getMessage("message.regSuccLink", null, locale);
		
		MimeMessagePreparator mimeMessagePreparator=new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,"UTF-8");
				mimeMessageHelper.setTo(recipientAddress);
				mimeMessageHelper.setSubject(subject);
				mimeMessageHelper.setFrom(env.getProperty("mail.smtp.user"));
				 String text = "<html><body><h3>Hi "
		                    + khachHang.getTen()
		                    + ", Chào mừng bạn đến với AppleShop!</h3>"
		                    + "Nếu bạn không phải là người nhận thư này, vui lòng cho chúng tôi biết"
		                    + "<h3>Hoàn tất quá trình đăng kí tài khoản</h3>\"\r\n" + 
		                    "                +\"<img src='https://static.javatpoint.com/images/spimages/spring1.png'>"
		                    +" \r\n"+ confirmationUrl  +  "</body></html>"
		                                 
		                    ;
				mimeMessageHelper.setText(text,true);
				
			}
		};
		
		javaMail.send(mimeMessagePreparator);
		
	}

}
