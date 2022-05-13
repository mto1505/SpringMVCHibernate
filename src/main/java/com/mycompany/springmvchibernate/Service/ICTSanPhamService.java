package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;

public interface ICTSanPhamService {
	
		public void save(ChiTietSanPhamDTO xe);	
	    public void delete(String [] ids);    
	    public void delete(String id);
	    public ChiTietSanPhamDTO update(ChiTietSanPhamDTO xe);
	    public List<ChiTietSanPhamDTO>findAll(Pageable pageable);
	    public List<ChiTietSanPhamDTO>findAll();
	    int getTotalItem();
	    public List<ChiTietSanPhamDTO>findAllByIdSanPham(int id);
	    public ChiTietSanPhamDTO findOneById(Integer id);
}
