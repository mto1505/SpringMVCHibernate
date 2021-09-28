package com.mycompany.springmvchibernate.TestProfile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.mycompany.springmvchibernate.JUnitTest.TestJacksonUnit;

public class TestProfile {
	
	public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
    
    public static void loadFile() 
    { 	
    	TestJacksonUnit app=new TestJacksonUnit();
    	Properties prop = app.loadPropertiesFile("test.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
    }
    public static void main(String[] args) {
		loadFile();
	}
}
