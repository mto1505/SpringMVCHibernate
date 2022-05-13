package com.mycompany.springmvchibernate.Config;


import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
@Component // hỗ trợ dependency Injection
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	 private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.onAuthenticationSuccess(request, response, authentication);
	}

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	
	protected String determineTargetUrl(Authentication authentication) {
		// TODO Auto-generated method stub

		    Map<String, String> roleTargetUrlMap = new HashMap<>();
		    roleTargetUrlMap.put("ROLE_USER", "/home");
		    roleTargetUrlMap.put("ROLE_ADMIN", "/quan-tri/trang-chu");

		    final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		    for (final GrantedAuthority grantedAuthority : authorities) {
		        String authorityName = grantedAuthority.getAuthority();
		        if(roleTargetUrlMap.containsKey(authorityName)) {
		            return roleTargetUrlMap.get(authorityName);
		        }
		    }

		    return null;
		
	}
    
	
   }
   
