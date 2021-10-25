package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.Entity.Chip;
import com.mycompany.springmvchibernate.Repositories.ChipRepository;
import com.mycompany.springmvchibernate.Service.IChipService;
@Service
public class ChipService implements IChipService {
	
	@Autowired
	ChipRepository chipRepository;
	
	@Override
	public List<Chip> findAll() {
		// TODO Auto-generated method stub
		return chipRepository.findAll();
	}

	@Override
	public Chip findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Chip xe) {
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
	public Chip update(Chip xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chip findOne(String ten, String sdt) {
		// TODO Auto-generated method stub
		return null;
	}

}
