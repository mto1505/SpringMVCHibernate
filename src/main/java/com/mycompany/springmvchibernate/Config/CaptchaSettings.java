package com.mycompany.springmvchibernate.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("captcha")
@PropertySource("classpath:application.properties")
public class CaptchaSettings {
	
	@Value("${google.recaptcha.key.site}")
	private String key;
	@Value("${google.recaptcha.key.secret}")
	private String secret;
	@Value("${google.recaptcha.key.url}")
	
	private String url;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
