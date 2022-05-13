package com.mycompany.springmvchibernate.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvchibernate.Entity.ChiTietGioHang;
import com.mycompany.springmvchibernate.Entity.ChiTietGioHangPK;
@Repository
public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, ChiTietGioHangPK>{
	
	public List<ChiTietGioHang> findByidIdGh(Integer id);
	
	@Transactional
	public void deleteByidIdGhAndIdIdCtsp(int gh,int idCtsp); 
}
