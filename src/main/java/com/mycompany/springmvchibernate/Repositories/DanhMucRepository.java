package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springmvchibernate.Entity.Loai;

public interface DanhMucRepository extends JpaRepository<Loai,String>{
	
	
}
