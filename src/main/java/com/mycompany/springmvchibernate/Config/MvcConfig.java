package com.mycompany.springmvchibernate.Config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	private static final Logger LOG = LoggerFactory.getLogger(MvcConfig.class);
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        exposeDirectory("product-photos", registry);
	    }
	     
	    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
	        Path uploadDir = Paths.get(dirName);
	        //String uploadPath = uploadDir.toFile().getAbsolutePath();
	         String uploadPath=FileUploadUtil.UPLOADED_FOLDER+dirName;
	        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
	         LOG.info("upload path"+uploadPath);
	        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+uploadPath+"/");
	       // First, we configure the external-facing URI path by adding defining a resource handler. 
	        //Then, we map that external-facing URI path internally to the physical path where the resources are actually located.	
	    }

}
