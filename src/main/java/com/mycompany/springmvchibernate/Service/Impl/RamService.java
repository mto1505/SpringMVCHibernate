package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.RamDTO;
import com.mycompany.springmvchibernate.Entity.Ram;
import com.mycompany.springmvchibernate.Repositories.RamRepository;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.IRamService;;
@Service
public class RamService implements IRamService{

	@Autowired
	RamRepository ramRepository;

	@Override
	public List<Ram> findAll() {
		// TODO Auto-generated method stub
		return ramRepository.findAll();
	}

	@Override
	public Ram findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Ram xe) {
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
	public Ram update(Ram xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ram findOne(String ten, String sdt) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
