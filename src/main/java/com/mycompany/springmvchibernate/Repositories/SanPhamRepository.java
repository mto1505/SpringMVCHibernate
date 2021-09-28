package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springmvchibernate.Entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, String>{
		
}
