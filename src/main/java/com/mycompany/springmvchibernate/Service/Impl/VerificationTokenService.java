package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Entity.TaiKhoan;
import com.mycompany.springmvchibernate.Entity.VerificationTokenEntity;
import com.mycompany.springmvchibernate.Repositories.VerificationRepository;
import com.mycompany.springmvchibernate.Service.IVerificationTokenService;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConverter;
@Service
public class VerificationTokenService implements IVerificationTokenService {

	@Autowired
	VerificationRepository verificationRepo;
	   @Autowired
	    KhachHangConverter khachHangConvert;
	@Override
	public void save(VerificationTokenEntity xe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VerificationTokenEntity update(VerificationTokenEntity xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VerificationTokenEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createVerificationToken(KhachHang khachHang, String token) {
		// TODO Auto-generated method stub
		
		//VerificationTokenEntity verificationTokenEntity=verificationRepo.findOne(khachHang.getTaiKhoan().getVerificationCode().getId());
		VerificationTokenEntity verificationTokenEntity=new VerificationTokenEntity();
		verificationTokenEntity.setToken(token);
		TaiKhoan taiKhoan=khachHang.getTaiKhoan();
		verificationTokenEntity.setTaiKhoan(taiKhoan);
		verificationRepo.save(verificationTokenEntity);
		
	}

	@Override
	public VerificationTokenEntity findOneByToken(String token) {
		// TODO Auto-generated method stub
		return verificationRepo.findOneByToken(token);
	}

}
