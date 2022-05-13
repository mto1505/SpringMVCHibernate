package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
	public KhachHang findOneByGioHang_Id(Integer id);
	public KhachHang findOneByEmail(String email);
	
}
