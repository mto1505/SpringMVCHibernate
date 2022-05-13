package com.mycompany.springmvchibernate.Config;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.hibernate.jpamodelgen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationProvider;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.oidc.authentication.OidcAuthorizationCodeAuthenticationProvider;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationProvider;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTO.OAuth2UserInfo;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.Entity.AuthProvider;
import com.mycompany.springmvchibernate.Service.ITaiKhoanService;

/*@Configuration
@EnableWebSecurity
@ComponentScan("com.mycompany.springmvchibernate.**")*/
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ITaiKhoanService taiKhoanService;
	
    @Autowired
    private OidcUserService oidcUserService;
/*	OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest>
 * The authorization endpoint is the endpoint that 
	Spring Security uses to trigger an authorization request to the external server.
	authorizationEndpoint()
  	.baseUri("/oauth2/authorize-client")
	*/
	
	/*Dành cho LoginAuthenticationFilter
	 * 
	-------Custom Token Endpoint
	//The token endpoint processes access tokens.	
	
	//OAuth2AuthorizationClientRepository
	 	*loadAuthorizedClient(clientRegistrationID,Authentication,req)
	 	*saveAuthorizedClient(OAuth2AuthorizedClient )
	 	*removeAuthorizedClIENT(clientRegistrationID,Authentication,req) 
	
	*AuthorizationRequestRepository<OAuth2AuthorizationRequest> 
	*
	*/

    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .antMatchers("/template/**").permitAll().
         and().authorizeRequests().anyRequest().permitAll()
         .and().oauth2Login().userInfoEndpoint().customUserType(com.mycompany.springmvchibernate.DTO.UserPrincipal.class, "google")
         
         .userService(oAuth2UserService())
         .oidcUserService(oidcUserService)
         .and()
         .clientRegistrationRepository(clientRegistrationRepository());
		  http.addFilterAfter(new OAuth2AuthorizationRequestRedirectFilter(clientRegistrationRepository()), RequestCacheAwareFilter.class);
	      http.addFilterAfter(oAuth2LoginAuthenticationFilter(), OAuth2AuthorizationRequestRedirectFilter.class);
	      http.csrf().disable();
	}
	
	  @Bean
	  public ClientRegistrationRepository clientRegistrationRepository() {
	    ClientRegistration google = 
	     CommonOAuth2Provider.GOOGLE.getBuilder("google")
	            .clientId("544867202364-9a6e1a98bo9ich6um0fpcuq52qqfdv5m.apps.googleusercontent.com")
	            .clientSecret("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")
	            
	            .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
	            .redirectUriTemplate("http://localhost:8080/SpringMVCHibernate/login/oauth2/code/google")
	            .scope("email").userNameAttributeName("sub")
	            .build();

	    //inmemory is temporary
	    List<ClientRegistration> clientRegistrationList = new ArrayList<>();
	    clientRegistrationList.add(google);
	    return new InMemoryClientRegistrationRepository(clientRegistrationList);
	}
	  
	  
	 // dành cho OAuth2LoginAuthenticationFilter
	@Bean 
	public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() { 
	    return new 
	   InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}
	@Bean
	public DefaultAuthorizationCodeTokenResponseClient defaultAuthorizationCodeTokenResponseClient(){
	    return new DefaultAuthorizationCodeTokenResponseClient();
	}

	@Bean
	public DefaultOAuth2UserService defaultOAuth2UserService(){
	    return new DefaultOAuth2UserService();
	}
	@Bean(name = "oidcUserService")
	public OidcUserService oidcUserService(){
	    return new OidcUserService();
	}

	/*@Bean
	public OAuth2LoginAuthenticationProvider oAuth2LoginAuthenticationProvider(){
	    return new OAuth2LoginAuthenticationProvider(defaultAuthorizationCodeTokenResponseClient(),oAuth2UserService());
	}*/

	@Bean
	public OAuth2LoginAuthenticationFilter oAuth2LoginAuthenticationFilter() throws Exception {
	    OAuth2LoginAuthenticationFilter oAuth2LoginAuthenticationFilter =
	     new OAuth2LoginAuthenticationFilter(clientRegistrationRepository(),oAuth2AuthorizedClientService());
	    oAuth2LoginAuthenticationFilter.setAuthenticationManager(super.authenticationManagerBean());
	   
	    return oAuth2LoginAuthenticationFilter;
	}
	
	
	private OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService()
	{
		final DefaultOAuth2UserService delegate=new DefaultOAuth2UserService();
		
		return new OAuth2UserService<OAuth2UserRequest, OAuth2User>() {
			
			@Override
			public OAuth2User loadUser(OAuth2UserRequest userRequest)// throws OAuth2AuthenticationException
			{
				// TODO Auto-generated method stub
				OAuth2User oAuth2User= delegate.loadUser(userRequest);
				System.out.println("Dia chi email la:   "+oAuth2User.getAttribute("email").toString());
//				try {
//				return  processOAuth2User(userRequest, oAuth2User);
//				}
//				catch (AuthenticationException ex) {
//		            throw ex;
//		        } catch (Exception ex) {
//		            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
//		            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
//		        }
				return oAuth2User;
			}
		};
		
		/*return new OAuth2UserService<OAuth2UserRequest, OAuth2User>() {
			
			@Override
			public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
				// TODO Auto-generated method stub
				OidcUser oidcUser=(OidcUser) delegate.loadUser(userRequest);
				
				return oidcUser;
			}
		};*/
		
	}
	
	private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest,OAuth2User oAuth2User)
	{
		
		OAuth2UserInfo oAuth2UserInfo=OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
		if(!StringUtils.isEmpty(oAuth2UserInfo.getEmail()))
		{
				throw new AuthenticationException("Email not found from OAuth2 provider") {
				}; 

		}
		
		TaiKhoanDTO taiKhoan=taiKhoanService.findOneByKhachHangs_Email(oAuth2UserInfo.getEmail());
		if(taiKhoan!=null)
		{
			if(!taiKhoan.getProvider().equals(oAuth2UserRequest.getClientRegistration().getRegistrationId()))
			{
				
				throw new AuthenticationException("Looks like you're signed up with " +
                        taiKhoan.getProvider() + " account. Please use your " + taiKhoan.getProvider() +
                        " account to login.") {
				}; 
			}
			//update user
			taiKhoan.setImageUrl(oAuth2UserInfo.getImageUrL());
			taiKhoan.getKhachHangs().setTen(oAuth2UserInfo.getName());
			taiKhoanService.save(taiKhoan);
		}
		else {
			TaiKhoanDTO taiKhoanNew=new TaiKhoanDTO();
			KhachHangDTO khachHang=new KhachHangDTO();
			khachHang.setTen(oAuth2UserInfo.getName());
			taiKhoanNew.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
			taiKhoanNew.setKhachHangs(khachHang);
			taiKhoanNew.setImageUrl(oAuth2UserInfo.getImageUrL());
			taiKhoanNew.setProviderId(oAuth2UserInfo.getId());
			taiKhoanService.save(taiKhoanNew);
			
		}
		
		return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), oAuth2User.getName());
	}
	
	//@Bean
	public AuthenticationManager getAuthenticationManager() {
		AuthenticationManager authenticationManager=new ProviderManager(
				Arrays.asList(getAuthenticationProvider()));
	return authenticationManager;
	}
	//@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		
		AuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		
		return authenticationProvider;
	}
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		 DefaultHttpFirewall  firewall = new  DefaultHttpFirewall ();
	    firewall.setAllowUrlEncodedSlash(true);    
	    return firewall;
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
	    //@formatter:off
	    super.configure(web);
	    
	    web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	
	}
	/*
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

	}*/

			
}
