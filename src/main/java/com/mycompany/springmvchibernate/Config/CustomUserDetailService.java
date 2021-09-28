package com.mycompany.springmvchibernate.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.Quyen;
import com.mycompany.springmvchibernate.TaiKhoan;
import com.mycompany.springmvchibernate.DTODemo.MyUser;


/*@Service*/
public class CustomUserDetailService //implements UserDetailsService
{
	
	/*@Autowired
	public TaiKhoanRepository taiKhoanRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		TaiKhoan taiKhoan=taiKhoanRepository.findOne(username);
		if(taiKhoan!=null)
		{	
//			for(Quyen quyen:taiKhoan.getIdQuyen())
//			{
//				
//			}
			List<GrantedAuthority> authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(taiKhoan.getIdQuyen().getTenquyen()));
			MyUser myUser=new MyUser(username, taiKhoan.getMatkhau(), true, true, true, true, authorities);
			return myUser;
		}
		else {
			throw new UsernameNotFoundException("User not found");
		}
		
	}*/
		
}
