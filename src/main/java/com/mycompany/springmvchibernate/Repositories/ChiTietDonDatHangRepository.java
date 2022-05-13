package com.mycompany.springmvchibernate.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHangPK;

public interface ChiTietDonDatHangRepository extends JpaRepository<ChiTietDonDatHang, ChiTietDonDatHangPK>{
	
	List<ChiTietDonDatHang> findByIdIdDdh(int idDDH);
	
}
