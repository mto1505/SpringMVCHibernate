package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;
import com.mycompany.springmvchibernate.Entity.DonDatHang;
import com.mycompany.springmvchibernate.Repositories.DonDatHangRepository;
import com.mycompany.springmvchibernate.Service.IDonDatHangService;
import com.mycompany.springmvchibernate.Service.Convert.DonDatHangConvert;

@Service
public class DonDatHangService implements IDonDatHangService {
	
	@Autowired
	DonDatHangRepository donDatHang;
	@Autowired
	DonDatHangConvert ddhConvert;
	
	@Override
	public void save(DonDatHangDTO xe) {
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
	public DonDatHangDTO update(DonDatHangDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DonDatHangDTO> findAll(Pageable pageable) {
		Page<DonDatHang> orderPages=donDatHang.findAll(pageable);
		List<DonDatHang> orders=orderPages.getContent();
		return ddhConvert.toDTOs(orders);
	}

	@Override
	public List<DonDatHangDTO> findAll() {
		List<DonDatHang> orders=donDatHang.findAll();
		return ddhConvert.toDTOs(orders);
	}
	
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) donDatHang.count();
	}

	@Override
	public DonDatHangDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DonDatHangDTO findOneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalItem(Example<DonDatHang> ex) {
		// TODO Auto-generated method stub
		return (int) donDatHang.count(ex);
	}

	@Override
	public List<DonDatHangDTO> findAll(Example<DonDatHang> ex, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<DonDatHang> orderPages=donDatHang.findAll(ex,pageable);
		List<DonDatHang> orders=orderPages.getContent();
		return ddhConvert.toDTOs(orders);
	}

}
