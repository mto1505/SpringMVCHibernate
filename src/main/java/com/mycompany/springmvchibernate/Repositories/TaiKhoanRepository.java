package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.Entity.TaiKhoan;
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,Integer > {
	
	public TaiKhoan findOneByUsername(String userName);
	public TaiKhoan findOneByUsernameAndActive(String userName,boolean active);
	public TaiKhoan findOneByKhachHangs_Email(String email);
}
