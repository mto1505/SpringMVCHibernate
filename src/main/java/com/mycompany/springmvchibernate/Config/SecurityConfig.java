package com.mycompany.springmvchibernate.Config;
public class SecurityConfig {}
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;


public class SecurityConfig {
	
	@Bean
	public AuthenticationManager getAuthenticationManager() {
		AuthenticationManager authenticationManager=new ProviderManager(
				Arrays.asList(getAuthenticationProvider()));
	return authenticationManager;
	}
	@Bean
	private AuthenticationProvider getAuthenticationProvider() {
		
		AuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		
		return authenticationProvider;
	}
	@Bean(name="springSecurityFilterChain")
	public FilterChainProxy getFilterChainProxy() throws Exception
	{
		List listOfFilterChains=(List) new ArrayList();
		
		listOfFilterChains.add(new DefaultSecurityFilterChain(
				new AntPathRequestMatcher("/home**")));
		listOfFilterChains.add(new DefaultSecurityFilterChain(
				new AntPathRequestMatcher("/resources/**")));
		listOfFilterChains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"),securityContextPersistenceFilter(),
				usernamePasswordAuthenticationFilter(),exceptionTranslationFilter()));
		return null;
	}
	@Bean
	public SecurityContextPersistenceFilter securityContextPersistenceFilter() {
		return new SecurityContextPersistenceFilter(new HttpSessionSecurityContextRepository());
		
	}
	@Bean 
	public ExceptionTranslationFilter exceptionTranslationFilter() {
		ExceptionTranslationFilter exceptionTranslationFilter=new ExceptionTranslationFilter(new LoginUrlAuthenticationEntryPoint("/home"));
		
		AccessDeniedHandlerImpl accessDeniedHandlerImpl=new AccessDeniedHandlerImpl();
		
		accessDeniedHandlerImpl.setErrorPage("/exception");
		exceptionTranslationFilter.setAccessDeniedHandler(accessDeniedHandlerImpl);
		exceptionTranslationFilter.afterPropertiesSet();
		return exceptionTranslationFilter;
		
		
	}
	@Bean
	public AbstractAuthenticationProcessingFilter usernamePasswordAuthenticationFilter()
			throws Exception {
		AbstractAuthenticationProcessingFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
		usernamePasswordAuthenticationFilter
				.setAuthenticationManager(getAuthenticationManager());
		// super(new AntPathRequestMatcher("/login", "POST"));->
		//usernamePasswordAuthenticationFilter.setFilterProcessesUrl("/login");
		usernamePasswordAuthenticationFilter.setAllowSessionCreation(true);

		AuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
		usernamePasswordAuthenticationFilter
				.setAuthenticationSuccessHandler(successHandler);
		usernamePasswordAuthenticationFilter
				.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(
						"/home?error=true"));
		usernamePasswordAuthenticationFilter.afterPropertiesSet();

		return usernamePasswordAuthenticationFilter;
		
		

	}
	@Bean 
	public FilterSecurityInterceptor filterSecurityInterceptor() throws Exception
	{
		FilterSecurityInterceptor filterSecurityInterceptor=new FilterSecurityInterceptor();
		filterSecurityInterceptor.setAuthenticationManager(getAuthenticationManager());
		filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager());
		
		LinkedHashMap<RequestMatcher, Collection> requestMap=new LinkedHashMap<>();
		
	return filterSecurityInterceptor;
		
		
	}
	public AffirmativeBased accessDecisionManager() throws Exception {
		  
		List<AccessDecisionVoter<? extends Object>> voters=new ArrayList<>();
		voters.add(new RoleVoter()); //default pattern "ROLE_)" 
		voters.add(new AuthenticatedVoter());
		
		AffirmativeBased affirmativeBased=new AffirmativeBased(voters);
		affirmativeBased.setAllowIfAllAbstainDecisions(false); //default
		
		affirmativeBased.afterPropertiesSet();
		return affirmativeBased;
		return null;
	}

			
}
*/