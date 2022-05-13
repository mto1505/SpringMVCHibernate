package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.HinhAnhDTO;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Repositories.HinhAnhRepository;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.IHinhAnh;
@Service
public class HinhAnhService implements IHinhAnh{

	@Autowired
	HinhAnhRepository hinhAnhRepository;
	
	@Override
	public void save(HinhAnhSP xe) {
		// TODO Auto-generated method stub
		hinhAnhRepository.save(xe);
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
	public HinhAnhSP update(HinhAnhSP xe) {
		// TODO Auto-generated method stub
		return hinhAnhRepository.save(xe);
	}

	@Override
	public List<HinhAnhSP> findAll() {
		// TODO Auto-generated method stub
		return hinhAnhRepository.findAll();
		
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HinhAnhSP findById(int id) {
		// TODO Auto-generated method stub
		return hinhAnhRepository.findOne(id);
	}

	@Override
	public List<HinhAnhSP> findAllByIdSanPham(int id) {
		// TODO Auto-generated method stub	
		return hinhAnhRepository.findBySanPham_Id(id);
	}
	
}
