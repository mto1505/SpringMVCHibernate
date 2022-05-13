package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;

public interface ISanPhamService {
	
		public void save(SanPhamDTO xe);	
		public void addChiTietSanPham(Integer idSp,ChiTietSanPhamDTO ctsp);
	    public void delete(Integer [] ids);    
	    public void delete(Integer id);
	    public SanPhamDTO update(SanPhamDTO xe);
	    public List<SanPhamDTO>findAll(Pageable pageable);
	    public List<SanPhamDTO>findAll();
	    public List<SanPhamDTO>findAllSanPham();
	    public List<SanPhamDTO>findSanPhamAndDetail(int id);
	    int getTotalItem();
	    SanPhamDTO findById(String id);
	    public SanPhamDTO findOneById(Integer id);
	    public List<SanPhamDTO> findAllByListBienSoAndTen(List bienSo,String name);
	    public SanPhamDTO findByIdAndFetchChiTietEagerly(Integer id);
	    public List<SanPhamDTO> findAllAndFetchChiTietAnhHinhAnhEagerly(Pageable pageable);
	    public List<SanPhamDTO> findByTenLoai(String loai);
	    public List<SanPhamDTO> findByTenLoaiAndFetchChiTiet(String loai);
	    public List<SanPhamDTO> findByTenLoaiAndFetchChiTietAndHaveName(String tenLoai,String name );
	    public List<ChiTietSanPhamDTO> findBySellMore(int soLuongMua);
}	
