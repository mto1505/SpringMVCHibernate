package com.mycompany.springmvchibernate.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.DTO.UserDetailCustom;
import com.mycompany.springmvchibernate.Service.ITaiKhoanService;

public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	ITaiKhoanService taiKhoanService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		TaiKhoanDTO taiKhoanDTO=taiKhoanService.findOneByUsernameAndActive(username, true);
		if(taiKhoanDTO==null)
		{
			throw new UsernameNotFoundException("User not found");
			
		}
		List<GrantedAuthority> gas=new ArrayList<GrantedAuthority>();
		gas.add(new SimpleGrantedAuthority("ROLE_"+taiKhoanDTO.getVaiTro().getVaiTro()));
		
		return new UserDetailCustom("",taiKhoanDTO.getKhachHangs().getHoVaTenDem()+taiKhoanDTO.getKhachHangs().getTen(), taiKhoanDTO.getUsername(),taiKhoanDTO.getPassword(),taiKhoanDTO.getKhachHangs().getGioHang().getId(),true,gas);
	}

}
