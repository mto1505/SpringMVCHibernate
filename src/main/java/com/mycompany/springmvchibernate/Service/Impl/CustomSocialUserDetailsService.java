package com.mycompany.springmvchibernate.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;*/

import com.mycompany.springmvchibernate.DTO.SocialUserDetailCustom;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.DTO.UserDetailCustom;
import com.mycompany.springmvchibernate.Service.ITaiKhoanService;

public class CustomSocialUserDetailsService// implements SocialUserDetailsService
{
	
	/*@Autowired
	ITaiKhoanService taiKhoanService;
	
	public SocialUserDetails loadUserByUserId(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		TaiKhoanDTO taiKhoanDTO=taiKhoanService.findOne(username);
		if(taiKhoanDTO==null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> gas=new ArrayList<GrantedAuthority>();
		gas.add(new SimpleGrantedAuthority("ROLE_"+taiKhoanDTO.getVaiTro().getVaiTro()));
		SocialUserDetailCustom user=SocialUserDetailCustom.getBuilder()
				.username(taiKhoanDTO.getUsername()).password(taiKhoanDTO.getPassword())
				.authoritys(gas)
				.idGioHang(taiKhoanDTO.getKhachHangs().getGioHang().getId())
				.build();
				//(taiKhoanDTO.getUsername(),taiKhoanDTO.getPassword(),gas);
		return user;
	}*/
}
