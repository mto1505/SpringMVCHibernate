package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springmvchibernate.Entity.Ram;

public interface RamRepository extends JpaRepository<Ram, String>{
		
}
