package com.mycompany.springmvchibernate.Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class MyServletContextListener extends ContextLoader{

	public void contextInitialized(ServletContextEvent contextEvent)
	{	
		//code to initialize the database connection 
		// and store it as a context attribute
		
	}	
	
	public void contextDetroyed(ServletContextEvent contextEvent) {
			// code to close the database connection
		
	}
}
