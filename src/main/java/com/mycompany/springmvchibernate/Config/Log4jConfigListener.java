/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Config;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 *
 * @author MinhTo
 */
public class Log4jConfigListener implements ServletContextListener {
    @Override
public void contextDestroyed(ServletContextEvent servletcontextevent) {
    LogManager.shutdown();
}

@Override
public void contextInitialized(ServletContextEvent servletcontextevent) {

    ServletContext context = servletcontextevent.getServletContext();

    String path = null;

    path = context.getInitParameter("log4jConfigLocation");

    PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
    Resource[] resources = null;
    try {
        resources = pathResolver.getResources(path);

        for (Resource resource : resources) {
            File file = resource.getFile();
            path = file.getAbsolutePath();
            break; // read only the first configuration
        }
    } catch (IOException e) {
        context.log("Unable to load log4j configuration file", e);
    }

    LogManager.resetConfiguration();
    DOMConfigurator.configure(path);
}
}
