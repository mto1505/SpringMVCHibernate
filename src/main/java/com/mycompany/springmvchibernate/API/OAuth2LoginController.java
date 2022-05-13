package com.mycompany.springmvchibernate.API;

import java.security.Principal;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OAuth2LoginController {
	
	
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal)
	{
		OAuth2AuthenticationToken oAuth2AuthenticationToken=(OAuth2AuthenticationToken) principal;
		System.out.println("Dia chi email la:   "+oAuth2AuthenticationToken.getPrincipal().getAttribute("email").toString());
		return principal;
		
	}
}
