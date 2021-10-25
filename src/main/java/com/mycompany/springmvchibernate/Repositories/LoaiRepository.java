package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.Entity.Loai;
@Repository
public interface LoaiRepository extends JpaRepository<Loai, String>{

}
