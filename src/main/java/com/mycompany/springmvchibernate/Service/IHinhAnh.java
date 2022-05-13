package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.HinhAnhDTO;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;

public interface IHinhAnh {
	
		public void save(HinhAnhSP xe);	
	    public void delete(String [] ids);    
	    public void delete(String id);
	    public HinhAnhSP update(HinhAnhSP xe);
	    public List<HinhAnhSP>findAll();
	    int getTotalItem();
	    HinhAnhSP findById(int id);
	    public List<HinhAnhSP>findAllByIdSanPham(int id);
	  
}
