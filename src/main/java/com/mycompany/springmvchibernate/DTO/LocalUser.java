package com.mycompany.springmvchibernate.DTO;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class LocalUser extends User implements OidcUser//, OAuth2User
{
	
	public LocalUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final OidcIdToken OidcIdToken;
	
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getClaims() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OidcUserInfo getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OidcIdToken getIdToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
