package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.HinhAnhDTO;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;

public interface IHinhAnh {
	
		public void save(HinhAnhDTO xe);	
	    public void delete(String [] ids);    
	    public void delete(String id);
	    public HinhAnhSP update(HinhAnhDTO xe);
	    public List<HinhAnhSP>findAll();
	    int getTotalItem();
	    HinhAnhDTO findById(String id);
	    public List<HinhAnhSP>findAllByIdSanPham(String id);
	  
}
