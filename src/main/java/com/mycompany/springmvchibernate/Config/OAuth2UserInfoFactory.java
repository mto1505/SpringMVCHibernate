package com.mycompany.springmvchibernate.Config;

import java.util.Map;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;

import com.mycompany.springmvchibernate.DTO.GoogleOAuth2UserInfo;
import com.mycompany.springmvchibernate.DTO.OAuth2UserInfo;
import com.mycompany.springmvchibernate.Entity.AuthProvider;

public class OAuth2UserInfoFactory {
	 public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
	        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
	            return new GoogleOAuth2UserInfo(attributes);
	        }/* else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
	            return new FacebookOAuth2UserInfo(attributes);
	        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
	            return new GithubOAuth2UserInfo(attributes);
	        } */else {
	            throw new AuthenticationException("Sorry! Login with " + registrationId + " is not supported yet.") {
	            	
				};
				
	        }
	    }
}
