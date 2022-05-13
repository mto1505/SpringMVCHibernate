/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Impl;

import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO2;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Repositories.DanhMucRepository;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConvertTest;
import com.mycompany.springmvchibernate.Service.IDanhMucService;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import com.mycompany.springmvchibernate.Specification.KhachHangSpecification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
@Component
public class DanhMucService implements IDanhMucService
{
	@Autowired
	private DanhMucRepository danhMucRepository;

	
	@Override
	public List<Loai> findAll() {
		return danhMucRepository.findAll();
	}

	@Override
	public Loai findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Loai xe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Loai update(Loai ob) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
