package com.mycompany.springmvchibernate.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
@Repository
public interface HinhAnhRepository  extends JpaRepository<HinhAnhSP, Integer>{
		
	List<HinhAnhSP> findBySanPham_Id(Integer id);
}
