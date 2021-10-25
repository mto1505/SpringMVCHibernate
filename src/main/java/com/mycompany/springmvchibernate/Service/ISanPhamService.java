package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.SanPhamDTO;

public interface ISanPhamService {
	
		public void save(SanPhamDTO xe);	
	    public void delete(Integer [] ids);    
	    public void delete(Integer id);
	    public SanPhamDTO update(SanPhamDTO xe);
	    public List<SanPhamDTO>findAll(Pageable pageable);
	    public List<SanPhamDTO>findAll();
	    int getTotalItem();
	    SanPhamDTO findById(String id);
	    public SanPhamDTO findOneById(Integer id);
	    public List<SanPhamDTO> findAllByListBienSoAndTen(List bienSo,String name);
	    public SanPhamDTO findByIdAndFetchChiTietEagerly(Integer id);
	    public List<SanPhamDTO> findAllAndFetchChiTietAnhHinhAnhEagerly(Pageable pageable);
}	
