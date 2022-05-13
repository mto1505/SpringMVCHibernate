package com.mycompany.springmvchibernate.Repositories;

import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaUpdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvchibernate.DTO.LoaiDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;

import com.mycompany.springmvchibernate.Entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>,SanPhamRepositoryCustom<SanPham,Integer>{
		
	
	/*@Query("SELECT new com.mycompany.springmvchibernate.DTO.XeMayDTO(x.bienSo,x.tenxe,kh.ten,l.tenloai) FROM XeMay as x"
            + " join x.khachHang as kh "
            + "join x.loaiXe as l")*/
	//@Query("select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.cameraSau,s.cameraTruoc,s.chiTietSanPhams,s.id) from SanPham s join s.chiTietSanPhams")
			//+ " inner join s.hinhAnhSps ha on ha.sanPham=s.id ")
	//@Query("select s from SanPham s left join fetch s.hinhAnhSps")
	List<SanPham> findAll();
	//@Query("select s from SanPham s join fetch s.chiTietSanPhams ")
	//.chiTietSanPhams,s.cameraSau,s.cameraTruoc,s.id,s.loai,s.manHinh,s.moTa,s.pinSac,s.sim,s.ten
	@Query("select distinct s from SanPham s left join fetch s.chiTietSanPhams")
	List<SanPham> findAllAndFetchChiTiet();
	/*int id, String cameraSau, String cameraTruoc, String manHinh, String moTa, String name,
	String pinSac, String sim, LoaiDTO loai
	@Query("select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.id,s.cameraSau,s.cameraTruoc,s.manHinh,s.moTa,s.ten,s.pinSac,s.sim)"
			+ " from SanPham s left join fetch s.chiTietSanPhams  where s.loai.ten=:tenLoai")*/
	/*@Query("select s from SanPham s left join s.chiTietSanPhams left join s.hinhAnhSps where s.loai.ten=:tenLoai")
	public List<SanPham> findByTenLoaiAndFetchChiTiet(@Param("tenLoai") String tenLoai );*/
		
	List<SanPham> findByLoaiTen(String tenLoai);
	
	@Transactional
	@Modifying
	@Query("delete from SanPham s where s.id IN :ids")
/*	void deteteSanPhamByIds(@Param("ids")List<Integer> ids);*/
	public void deleteByIdIn(@Param("ids")List<Integer> ids);
	
	List<SanPham> findSanPhamAndDetail(int idSanPham);
	
		
	
	
	
	
	
}
