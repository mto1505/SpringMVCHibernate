package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Repositories.ChiTietSanPhamRepository;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
import com.mycompany.springmvchibernate.Service.Convert.ChiTietSanPhamConvert;

@Service
public class ChiTietSanPhamService implements ICTSanPhamService{

	@Autowired
	private ChiTietSanPhamRepository chiTietSanPhamRepository;
	
	@Autowired
	private ChiTietSanPhamConvert chiTietSanPhamConvert;
	
	
	@Override
	public void save(ChiTietSanPhamDTO xe) {
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
	public ChiTietSanPhamDTO update(ChiTietSanPhamDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietSanPhamDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietSanPhamDTO> findAll() {
		List<ChiTietSanPham> list=chiTietSanPhamRepository.findAll();
		return chiTietSanPhamConvert.toDTOs(list);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ChiTietSanPhamDTO> findAllByIdSanPham(int id) {
		List<ChiTietSanPham> list=chiTietSanPhamRepository.findBySanPham_Id(id);
		return chiTietSanPhamConvert.toDTOs(list);
	}

	@Override
	public ChiTietSanPhamDTO findOneById(Integer id) {
		// TODO Auto-generated method stub
		ChiTietSanPham chiTietSanPham=chiTietSanPhamRepository.findOne(id);
		return chiTietSanPhamConvert.toDTO(chiTietSanPham);
	}
	
}
