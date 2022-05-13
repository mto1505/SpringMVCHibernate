package com.mycompany.springmvchibernate.Controller;

import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
/*import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.Config.CaptchaSettings;
import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Entity.TaiKhoan;
import com.mycompany.springmvchibernate.Entity.VerificationTokenEntity;
import com.mycompany.springmvchibernate.Event.OnRegistrationCompleteEvent;
import com.mycompany.springmvchibernate.Repositories.VerificationRepository;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import com.mycompany.springmvchibernate.Service.ITaiKhoanService;
import com.mycompany.springmvchibernate.Service.IVerificationTokenService;
import com.mycompany.springmvchibernate.SpringValidator.KhachHangEqualsValidator;

@Controller
@RequestMapping
public class DangKiController {
/*	@Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;
 
    @Autowired
    private UsersConnectionRepository connectionRepository;*/
	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	IKhachHangService khachHangService;
	@Autowired
	ITaiKhoanService taiKhoanService;
	@Autowired
	IVerificationTokenService verificationTokenService;
	
	@Autowired
	MessageSource messageSource;
	@Autowired
	CaptchaSettings captcha;
	/*@InitBinder("khachHangDTO")
	 protected void initBinderFileBucket(WebDataBinder binder) {
        binder.setValidator(khachHangEqualsValidator);
    }*/
/*	@InitBinder
	protected void initBinder(WebDataBinder binder){
	  if (binder.getTarget() != null 
	      && KhachHangDTO.class.equals(binder.getTarget().getClass())) {
	    binder.setValidator(new KhachHangEqualsValidator ());
	  }
	}*/
	@RequestMapping(value="dang-ki",method=RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute(name="khachHang") @Validated KhachHangDTO khachHangDTO,BindingResult bindingResult,HttpServletRequest req,Model model)
	{
		System.out.println("reCapcha "+captcha.getKey());
		model.addAttribute("captcha",captcha);
		System.out.println("reCapcha "+khachHangDTO.getReCaptchaResponse());
		if(bindingResult.hasErrors())
		{	
			req.setAttribute("signUpfailed", true);
			
			return new ModelAndView("register");
		} 
		try{
		KhachHang khachHang=khachHangService.registerNewKhachHangAccount(khachHangDTO);
		String appUrl="http://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
		applicationEventPublisher.publishEvent(new OnRegistrationCompleteEvent(khachHang,appUrl, req.getLocale()));
		}catch (EntityExistsException e) {
			ModelAndView mav=new ModelAndView("register","khachHang",khachHangDTO);
			mav.addObject("email_error_message","Email đã tồn tại");
			mav.addObject("signUpfailed", true);
			return mav;
		}
		return new ModelAndView("redirect:/dang-nhap");
	}
	
	@RequestMapping("/registrationConfirm")
	public ModelAndView confirmRegistration(@RequestParam(name="token") String token,ModelMap model,WebRequest rq)
	{
		
		Locale locale=rq.getLocale();
		model.addAttribute("lang",locale.getLanguage());
		VerificationTokenEntity verificationTokenEntity=verificationTokenService.findOneByToken(token);
		if(verificationTokenEntity==null)
		{
			// String message = messageSource.getMessage("auth.message.invalidToken", null, locale);
			 model.addAttribute("message","auth.message.invalidToken");
			 return new ModelAndView("redirect:/badUser",model);
		}
		final TaiKhoan taiKhoan = verificationTokenEntity.getTaiKhoan();
        final Calendar cal = Calendar.getInstance();
		if(verificationTokenEntity.getExpiryDate().getTime()-cal.getTime().getTime()<=0)
		{	model.addAttribute("expired", true);
			model.addAttribute("message","auth.message.expired");
			model.addAttribute("token", token);
			return new ModelAndView("redirect:/badUser",model);
		}
		taiKhoan.setActive(true);
		taiKhoanService.setActive(taiKhoan);
		// String message = messageSource.getMessage("auth.message.accountVerified", null, locale);
		 model.addAttribute("message","auth.message.accountVerified");
		 return new ModelAndView("redirect:/badUser",model);
	}
	@RequestMapping("/badUser")
    public ModelAndView badUser(final HttpServletRequest request, final ModelMap model, @RequestParam("message" ) final Optional<String> messageKey, @RequestParam("expired" ) final Optional<String> expired, @RequestParam("token" ) final Optional<String> token) {

        Locale locale = request.getLocale();
        messageKey.ifPresent( key -> {
                    String message = messageSource.getMessage(key, null, locale);
                    model.addAttribute("message", message);
                }
        );

        expired.ifPresent( e -> model.addAttribute("expired", e));
        token.ifPresent( t -> model.addAttribute("token", t));

        return new ModelAndView("badUser", model);
    }
	/*@RequestMapping("/signin")
	public String loginGG(WebRequest req) 	
	{	
		
		RequestAttributes reqAtr=(RequestAttributes) req.getAttribute("connection",0);
		ProviderSignInUtils providerSignInUtils=new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
		 Connection<?> connection = providerSignInUtils.getConnectionFromSession(req);
		  if (connection != null) {
	            UserProfile socialMediaProfile = connection.fetchUserProfile();
	            socialMediaProfile.getEmail();
		  }
		  
		  return null;
	}*/
	//Connection<?> connection = ProviderSignInUtils.getConnection(request);
}
