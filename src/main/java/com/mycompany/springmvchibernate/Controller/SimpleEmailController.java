package com.mycompany.springmvchibernate.Controller;

import javax.faces.annotation.RequestMap;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
import com.mycompany.springmvchibernate.Service.Impl.SanPhamService;
import com.nimbusds.jose.util.StandardCharset;

@Controller
public class SimpleEmailController {

	@Autowired(required=false)
	JavaMailSender mailSender;

	@ResponseBody
	@RequestMapping("/send-mail")
	public String sendSimpleMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("n18dccn190@student.ptithcm.edu.vn");
		simpleMailMessage.setSubject("I'm testing email");
		simpleMailMessage.setText("Hello");
		mailSender.send(simpleMailMessage);
		return "Email sent";
	}

	@RequestMapping("/send-mail-mime")
	public String sendMimeMessage() {
		register("n18dccn190@student.ptithcm.edu.vn");
		return "";

	}

	public void register(String name) {
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,StandardCharset.UTF_8.name());
				mimeMessageHelper.setFrom("nguyenthanhtu@gmail.com");
				mimeMessageHelper.setTo(name);
				mimeMessageHelper.setSubject("Xác nhận đăng kí");
				 String text = "<html><body><h3>Hi "
		                    + name
		                    + ", welcome to AppleShop!</h3>"
		                    + "If you were not an intended recipient, Please notify the sender."
		                    + "<h3>Im testing send a HTML email</h3>\"\r\n" + 
		                    "                +\"<img src='http://www.apache.org/images/asf_logo_wide.gif'></body></html>"                   
		                    ;
				 
		        mimeMessageHelper.setText(text, true);
			}
		});
	}

}
