package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.Entity.TaiKhoan;
import com.mycompany.springmvchibernate.Repositories.TaiKhoanRepository;
import com.mycompany.springmvchibernate.Service.ITaiKhoanService;
import com.mycompany.springmvchibernate.Service.Convert.TaiKhoanConvert;
@Service
public class TaiKhoanService implements ITaiKhoanService{

	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	@Autowired
	TaiKhoanConvert taiKhoanConvert;
	@Override
	public List<TaiKhoanDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoanDTO findOne(String username) {
		// TODO Auto-generated method stub
		return taiKhoanConvert.toDTO(taiKhoanRepository.findOneByUsername(username));
	}

	@Override
	public void save(TaiKhoanDTO xe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaiKhoanDTO update(TaiKhoanDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaiKhoanDTO findOne(String ten, String sdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActive(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		taiKhoan.setActive(true);
		taiKhoanRepository.save(taiKhoan);
	}

	@Override
	public TaiKhoanDTO findOneByUsernameAndActive(String ten, boolean active) {
		// TODO Auto-generated method stub
		return taiKhoanConvert.toDTO(taiKhoanRepository.findOneByUsernameAndActive(ten, true));
	}

	@Override
	public TaiKhoanDTO findOneByKhachHangs_Email(String email) {
		// TODO Auto-generated method stub
		TaiKhoan taiKhoan=taiKhoanRepository.findOneByKhachHangs_Email(email);
		if(taiKhoan!=null)
		{
			taiKhoanConvert.toDTO(taiKhoan);
			
		}
		return null;
	}

}
