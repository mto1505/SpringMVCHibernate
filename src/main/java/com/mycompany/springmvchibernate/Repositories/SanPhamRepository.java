package com.mycompany.springmvchibernate.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.DTO.SanPhamDTO;

import com.mycompany.springmvchibernate.Entity.SanPham;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{
		
	
	/*@Query("SELECT new com.mycompany.springmvchibernate.DTO.XeMayDTO(x.bienSo,x.tenxe,kh.ten,l.tenloai) FROM XeMay as x"
            + " join x.khachHang as kh "
            + "join x.loaiXe as l")*/
	//@Query("select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.cameraSau,s.cameraTruoc,s.chiTietSanPhams,s.id) from SanPham s join s.chiTietSanPhams")
			//+ " inner join s.hinhAnhSps ha on ha.sanPham=s.id ")
	/*@Query("select s from SanPham as s")*/
	
	List<SanPham> findAll();
	//@Query("select s from SanPham s join fetch s.chiTietSanPhams ")
	//.chiTietSanPhams,s.cameraSau,s.cameraTruoc,s.id,s.loai,s.manHinh,s.moTa,s.pinSac,s.sim,s.ten
	@Query("select s from SanPham s left join fetch s.chiTietSanPhams")
	List<SanPham> findAllAndFetchChiTiet();
	
	
	
}
