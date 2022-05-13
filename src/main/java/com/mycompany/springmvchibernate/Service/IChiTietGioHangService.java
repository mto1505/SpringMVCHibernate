package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;

public interface IChiTietGioHangService {
	
	public void save(ChiTietGioHangDTO xe);

	public void delete(Integer[] ids);

	public void delete(Integer id);

	public ChiTietGioHangDTO update(ChiTietGioHangDTO xe);

	public List<ChiTietGioHangDTO> findAll(Pageable pageable);

	public List<ChiTietGioHangDTO> findAll();

	int getTotalItem();
	public List<ChiTietGioHangDTO> findByidIdGh(Integer id);
	
	public void deleteByIdGhAndIdCtsp(int gh,int ctsp);
}
