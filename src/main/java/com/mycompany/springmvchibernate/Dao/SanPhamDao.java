package com.mycompany.springmvchibernate.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.Entity.SanPham;


public interface SanPhamDao {
	public List<SanPham> findAll();
}
