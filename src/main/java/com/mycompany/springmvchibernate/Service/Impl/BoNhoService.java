package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.Entity.BoNho;
import com.mycompany.springmvchibernate.Repositories.BoNhoRepository;
import com.mycompany.springmvchibernate.Service.IBoNhoService;

@Service
public class BoNhoService implements IBoNhoService{
	
	@Autowired
	BoNhoRepository boNhoRepository;
	
	@Override
	public List<BoNho> findAll() {
		// TODO Auto-generated method stub
		return boNhoRepository.findAll();
	}

	@Override
	public BoNho findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(BoNho xe) {
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
	public BoNho update(BoNho xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoNho findOne(String ten, String sdt) {
		// TODO Auto-generated method stub
		return null;
	}

}
