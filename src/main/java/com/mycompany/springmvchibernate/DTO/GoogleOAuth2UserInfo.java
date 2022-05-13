package com.mycompany.springmvchibernate.DTO;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {

	public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return getAttributes().get("id").toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		 	return getAttributes().get("name").toString();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		 	return getAttributes().get("email").toString();
	}

	@Override
	public String getImageUrL() {
		// TODO Auto-generated method stub
		return getAttributes().get("picture").toString();
	}
	
}
