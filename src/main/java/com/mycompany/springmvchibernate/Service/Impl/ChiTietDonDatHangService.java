package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Repositories.ChiTietDonDatHangRepository;
import com.mycompany.springmvchibernate.Service.IChiTietDonDatHangService;
@Service
public class ChiTietDonDatHangService implements IChiTietDonDatHangService{

	@Autowired
	ChiTietDonDatHangRepository ctddhRepository;
	@Override
	public void save(ChiTietDonDatHang xe) {
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
	public ChiTietDonDatHang update(ChiTietDonDatHang xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietDonDatHang> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietDonDatHang> findAll() {
		return ctddhRepository.findAll();
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public ChiTietDonDatHang findOneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietDonDatHang> findByIdIdDDH(int id) {
		// TODO Auto-generated method stub
		return ctddhRepository.findByIdIdDdh(id);
	}

	

}
