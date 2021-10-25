package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.Entity.Mau;
import com.mycompany.springmvchibernate.Repositories.MauRepository;
import com.mycompany.springmvchibernate.Service.IMauService;
@Service
public class MauService implements IMauService{
	@Autowired
	MauRepository mauRepository;
	
	@Override
	public List<Mau> findAll() {
		// TODO Auto-generated method stub
		return mauRepository.findAll();
	}

	@Override
	public Mau findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Mau xe) {
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
	public Mau update(Mau xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mau findOne(String ten, String sdt) {
		// TODO Auto-generated method stub
		return null;
	}

}
