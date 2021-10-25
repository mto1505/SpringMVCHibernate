package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.springmvchibernate.Entity.Chip;

public interface ChipRepository extends JpaRepository<Chip, String>{
		
}
