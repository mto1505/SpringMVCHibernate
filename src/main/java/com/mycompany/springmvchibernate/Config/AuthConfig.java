/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
*/
/**
 *
 * @author MinhTo
 */
/*@Configuration
@EnableWebSecurity*/
public class AuthConfig{


   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        {		
        	   http.apply(new SpringSocialConfigurer())
               //
               .signupUrl("/signup").postFailureUrl("/dang-nhap");
        	   http.authorizeRequests().antMatchers("/auth/**").permitAll().anyRequest().authenticated();
        	   

       
            
        }
    }*/

	/*@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
*/
	
    
}
