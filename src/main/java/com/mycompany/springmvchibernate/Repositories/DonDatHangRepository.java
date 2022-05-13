package com.mycompany.springmvchibernate.Repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.Entity.DonDatHang;
@Repository
public interface DonDatHangRepository extends JpaRepository<DonDatHang, Integer>{
	
	
}
