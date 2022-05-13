package com.mycompany.springmvchibernate.Filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class ReCaptchaResponseFilter
 */
@Component
public class ReCaptchaResponseFilter implements Filter {
	private static final String RE_CAPTCHA_ALIAS = "reCaptchaResponse";
    private static final String RE_CAPTCHA_RESPONSE = "g-recaptcha-response"; //api gg return the tokens inside "g-recaptcha-response" requet parameter
    /**
     * Default constructor. 
     */
    public ReCaptchaResponseFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		
		if (httpServletRequest.getParameter(RE_CAPTCHA_RESPONSE) != null) {
            ReCaptchaHttpServletRequest reCaptchaRequest = new ReCaptchaHttpServletRequest(httpServletRequest);
            chain.doFilter(reCaptchaRequest, httpServletResponse);
        } else {
            chain.doFilter(httpServletRequest, response);
        }

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	 private static class ReCaptchaHttpServletRequest extends HttpServletRequestWrapper {

	        final Map<String, String[]> params;

	        ReCaptchaHttpServletRequest(HttpServletRequest request) {
	            super(request);
	            params = new HashMap<>(request.getParameterMap());
	            params.put(RE_CAPTCHA_ALIAS, request.getParameterValues(RE_CAPTCHA_RESPONSE));
	        }

	        @Override
	        public String getParameter(String name) {
	            return params.containsKey(name) ? params.get(name)[0] : null;
	        }

	        @Override
	        public Map<String, String[]> getParameterMap() {
	            return params;
	        }

	        @Override
	        public Enumeration<String> getParameterNames() {
	            return Collections.enumeration(params.keySet());
	        }

	        @Override
	        public String[] getParameterValues(String name) {
	            return params.get(name);
	        }
	    }

}
