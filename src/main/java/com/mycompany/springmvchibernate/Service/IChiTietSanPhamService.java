package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;


import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;

public interface IChiTietSanPhamService {
	
		public void save(ChiTietSanPham xe);	
	    public void delete(Integer [] ids);    
	    public void delete(Integer id);
	    public ChiTietSanPham update(ChiTietSanPham xe);
	    public List<ChiTietSanPham>findAll(Pageable pageable);
	    public List<ChiTietSanPham>findAll();
	    int getTotalItem();
	    ChiTietSanPham findById(String id);
	    public ChiTietSanPham findOneById(Integer id);
	    public List<ChiTietSanPham> findAllByListBienSoAndTen(List bienSo,String name);
	    public ChiTietSanPham findByIdAndFetchChiTietEagerly(Integer id);
	    public List<ChiTietSanPham> findAllAndFetchChiTietAnhHinhAnhEagerly(Pageable pageable);
	    public List<ChiTietSanPham> findByTenLoai(String loai);
	    public List<ChiTietSanPham> findByTenLoaiAndFetchChiTiet(String loai);
}	
