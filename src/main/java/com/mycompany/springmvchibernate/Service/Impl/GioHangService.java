package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.GioHangDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Repositories.ChiTietGioHangRepository;
import com.mycompany.springmvchibernate.Repositories.ChiTietSanPhamRepository;
import com.mycompany.springmvchibernate.Repositories.GioHangRepository;
import com.mycompany.springmvchibernate.Service.IGioHangService;

public class GioHangService implements IGioHangService{

	@Autowired
	GioHangRepository gioHangRepository;
	
	@Autowired
	ChiTietGioHangRepository ctghRepository;
	@Autowired
	ChiTietSanPhamRepository ctspRepository;
	
	@Override
	public void addChiTietGioHang(int idGioHang,ChiTietGioHangDTO chiTietGioHangDTO) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void save(GioHangDTO xe) {
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
	public GioHangDTO update(GioHangDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GioHangDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GioHangDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
