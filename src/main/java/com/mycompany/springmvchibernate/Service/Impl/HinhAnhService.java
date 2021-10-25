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
	public void save(HinhAnhDTO xe) {
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
	public HinhAnhSP update(HinhAnhDTO xe) {
		// TODO Auto-generated method stub
		return null;
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
	public HinhAnhDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HinhAnhSP> findAllByIdSanPham(String id) {
		// TODO Auto-generated method stub	
		return hinhAnhRepository.findBySanPham_Id(id);
	}
	
}
