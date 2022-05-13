package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Entity.VerificationTokenEntity;

public interface IVerificationTokenService {
	
	public void save(VerificationTokenEntity xe);	
    public void delete(Integer [] ids);    
    public void delete(Integer id);
    public VerificationTokenEntity update(VerificationTokenEntity xe);
    public List<VerificationTokenEntity>findAll();
    public VerificationTokenEntity findOneByToken(String token);
    int getTotalItem();
    public void createVerificationToken(KhachHang khachHang,String token);
   
   
}
