package com.mycompany.springmvchibernate.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham,Integer>{
	
	
	List<ChiTietSanPham> findBySanPham_Id(Integer idSanPham);
	List<ChiTietSanPham> findAll();
}
