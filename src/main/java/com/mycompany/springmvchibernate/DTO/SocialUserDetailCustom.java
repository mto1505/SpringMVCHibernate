package com.mycompany.springmvchibernate.DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
/*import org.springframework.social.security.SocialUser;
*/
import com.mycompany.springmvchibernate.Entity.VaiTro;

public class SocialUserDetailCustom
//extends SocialUser
{
	/*public SocialUserDetailCustom(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	*/
	private Integer id;
	private String displayName;
	
    private String firstName;
 
    private String lastName;
 
    private VaiTro role;
    
    private int idGH;
    private String email;
  
    
    
    
    public static Builder getBuilder() {
		return new Builder();
	}
    
	public static class Builder {
    	 
        private Integer id;
    	private String displayName;
        private String username;
 
        private String firstName;
 
        private String lastName;
 
        private String password;
        private String email;
        
        private List<GrantedAuthority> authorities;
        private int idGH;
        
        public Builder() {
            this.authorities = new ArrayList<>();
        }
 
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
 
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }
 
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
 
        public Builder password(String password) {
            if (password == null) {
                password = "SocialUser";
            }
 
            this.password = password;
            return this;
        }
 
        public Builder authoritys(List<GrantedAuthority> authorities) {
           
            this.authorities=authorities;
 
            return this;
        }
        	
        public Builder email(String email)
        {
        	this.email=email;
        	return this;
        	
        }
       
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder displayName(String displayName)
        {
        	this.displayName=displayName;
        	return this;
        }
        public Builder idGioHang(int idGH)
        {
        	this.idGH=idGH;
        	return this;
        }
        /*public SocialUserDetailCustom build() {
        	SocialUserDetailCustom user = new SocialUserDetailCustom(username, password, authorities);
   
        	user.id = id;
            user.firstName = firstName;
            user.lastName = lastName;
            user.displayName=displayName;
            user.idGH=idGH;
            user.email=email;
            return user;
        }*/
    }

}
