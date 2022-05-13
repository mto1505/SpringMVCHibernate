package com.mycompany.springmvchibernate.Service.Impl;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.mycompany.springmvchibernate.Config.CaptchaSettings;
import com.mycompany.springmvchibernate.DTO.ReCaptchaResponse;

@Service
public class ReCatpchaService {
	private static final Logger log = LoggerFactory.getLogger(ReCatpchaService.class);
	@Autowired(required=false)
	private RestOperations restTemplate;
	
	@Autowired
	private CaptchaSettings captchaSettings;
	
	@Autowired(required=false)
	HttpServletRequest request;
	
	
	public boolean validate(String reCapchaResponse)
	{
		URI verifyUri=URI.create(String.format(captchaSettings.getUrl()+"?secret=%s&response=%s&remoteip=%s",captchaSettings.getSecret(),reCapchaResponse,request.getRemoteAddr()));
		 try {
	            ReCaptchaResponse response = restTemplate.getForObject(verifyUri, ReCaptchaResponse.class);
	            return response.isSuccess();
	        } catch (Exception ignored){
	            log.error("", ignored);
	            // ignore when google services are not available
	            // maybe add some sort of logging or trigger that'll alert the administrator
	        }

	        return true;
		
	}
}
