package com.mycompany.springmvchibernate.Config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class MvcConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private Environment env;
	
	private static final Logger LOG = LoggerFactory.getLogger(MvcConfig.class);
	@Override
	 public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/index").setViewName("index");
   
   }
	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        exposeDirectory("product-photos", registry);
	    }
	     
	    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
	     //   Path uploadDir = Paths.get(dirName);
	        //String uploadPath = uploadDir.toFile().getAbsolutePath();
	         String uploadPath=FileUploadUtil.UPLOADED_FOLDER+dirName;
	        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
	         LOG.info("upload path"+uploadPath);
	        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+uploadPath+"/");
	       // First, we configure the external-facing URI path by adding defining a resource handler. 
	        //Then, we map that external-facing URI path internally to the physical path where the resources are actually located.	
	    }
	    
	    @Bean("messageSource")
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource
	          = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("classpath:message");
	        messageSource.setUseCodeAsDefaultMessage(false);
	        messageSource.setCacheSeconds((int) TimeUnit.HOURS.toSeconds(1));
	        messageSource.setFallbackToSystemLocale(false);
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }
	    @Bean
	    public LocalValidatorFactoryBean validator() {
	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	        bean.setValidationMessageSource(messageSource());
	        return bean;
	    }
	   @Bean
	    public LocaleResolver localeResolver() {
	       CookieLocaleResolver localeResolver  = new CookieLocaleResolver();
	      localeResolver.setDefaultLocale(Locale.ENGLISH);
	      
	       return localeResolver;
	    }

	    @Bean
	    public LocaleChangeInterceptor localeChangeInterceptor() {
	       LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	       localeChangeInterceptor.setParamName("lang");
	       
	     
	       return localeChangeInterceptor;
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	    }
	   @Bean("multipartResolver")
	    public MultipartResolver getMultipartResolver()
	    {	
	    	CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
	    	multipartResolver.setMaxUploadSize(Integer.valueOf(env.getProperty("maxUploadSize")));//1mb
	    	multipartResolver.setMaxInMemorySize(Integer.valueOf(env.getProperty("maxInMemorySize")));
	    	
	    	return multipartResolver;
	    
	    }
	   @Bean
	    public RestTemplate restTemplate(ClientHttpRequestFactory httpRequestFactory) {
	        RestTemplate template = new RestTemplate(httpRequestFactory);
	        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	        return template;
	    }

	    @Bean
	    public ClientHttpRequestFactory httpRequestFactory(HttpClient httpClient) {
	        return new HttpComponentsClientHttpRequestFactory(httpClient);
	    }

	    @Bean
	    public HttpClient httpClient() {
	        return HttpClientBuilder.create().build();
	    }
	   

}
