package com.mycompany.springmvchibernate.Config;



import javax.sql.DataSource;

import org.apache.http.impl.auth.GGSSchemeBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
/*import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;*/

/*@Configuration
@EnableSocial*/
public class SocialContext //implements SocialConfigurer
{
    /*private boolean autoSignUp = false;
	@Autowired
	private DataSource dataSource;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
	       try {
	            this.autoSignUp = Boolean.parseBoolean(environment.getProperty("social.auto-signup"));
	        } catch (Exception e) {
	            this.autoSignUp = false;
	        }
		// TODO Auto-generated method stub
	       GoogleConnectionFactory gfactory = new GoogleConnectionFactory(
					environment.getProperty("google.app.id"),environment.getProperty("google.app.secret"));
	       gfactory.setScope(environment.getProperty("google.app.scope"));
		connectionFactoryConfigurer.addConnectionFactory(gfactory);
		 
	}

	@Override
	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		// TODO Auto-generated method stub
		return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator,Encryptors.noOpText());
	}
	
	@Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
*/
}
