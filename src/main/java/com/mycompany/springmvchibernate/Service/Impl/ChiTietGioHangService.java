package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHangPK;
import com.mycompany.springmvchibernate.Entity.GioHang;
import com.mycompany.springmvchibernate.Repositories.ChiTietGioHangRepository;
import com.mycompany.springmvchibernate.Service.IChiTietGioHangService;
import com.mycompany.springmvchibernate.Service.Convert.ChiTietGioHangConvert;

@Service
public class ChiTietGioHangService implements IChiTietGioHangService {
	
	@Autowired
	ChiTietGioHangRepository ctghRepo;
	@Autowired
	ChiTietGioHangConvert ctghConvert;
	
	@Override
	public void save(ChiTietGioHangDTO ctgh) {
		// TODO Auto-generated method stub
		GioHang gioHang=new GioHang();
		gioHang.setId(ctgh.getIdIdGh());
		ChiTietGioHang chiTietGioHang=ctghConvert.toEntity(ctgh);
		
		chiTietGioHang.setGioHang(gioHang);
		
		ctghRepo.save(chiTietGioHang);
		
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
	public ChiTietGioHangDTO update(ChiTietGioHangDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietGioHangDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietGioHangDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ChiTietGioHangDTO> findByidIdGh(Integer id) {
		// TODO Auto-generated method stub
		List<ChiTietGioHang> chiTietGioHangs=ctghRepo.findByidIdGh(id);
		return ctghConvert.toDTOs(chiTietGioHangs);
	}

	@Override
	public void deleteByIdGhAndIdCtsp(int ddh, int ctsp) {
		// TODO Auto-generated method stub
		ctghRepo.deleteByidIdGhAndIdIdCtsp(ddh, ctsp);
		
	}
		
}
