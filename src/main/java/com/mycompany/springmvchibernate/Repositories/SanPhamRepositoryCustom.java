package com.mycompany.springmvchibernate.Repositories;

import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.SanPham;

public interface SanPhamRepositoryCustom<SanPham,Integer> {
	
	public void customDeleteByIds(List<Integer> ids);
	//@Query("select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.hinhAnhSps,s.ten,s.c) from SanPham s left join fetch s.chiTietSanPhams as ct")
	public List<SanPham> findByTenLoaiAndFetchChiTiet(String loai);
	public void addChiTietSanPham(Integer id,ChiTietSanPham ctsp);
	public List findBySellMore(int soLuongMua );
	public List findSanPhamAndDetail(int id);
	public List<SanPham>findByTenLoaiAndFetchChiTietAndHaveName(String tenLoai,String name );
	public void print();
}
