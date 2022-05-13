/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Impl;


import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.springmvchibernate.DTO.GioHangDTO;
import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTO.TaiKhoanDTO;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO2;
import com.mycompany.springmvchibernate.Entity.GioHang;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Entity.VaiTro;
import com.mycompany.springmvchibernate.Entity.VerificationTokenEntity;
import com.mycompany.springmvchibernate.Repositories.KhachHangRepository;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConvertTest;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConverter;

/**
 *
 * @author MinhTo
 */
@Component
public class KhachHangService implements IKhachHangService
{
    @Autowired
    KhachHangRepository khachHangRepository;
    
    @Autowired
    KhachHangConverter khachHangConvert;

	@Override
	public List<KhachHangDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHangDTO findOne(String id) {
		// TODO Auto-generated method stub
		return null;
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
	public KhachHangDTO update(KhachHangDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHangDTO findOne(String ten, String sdt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHangDTO findOneByIdGioHang(int username) {
		KhachHang khachHang=khachHangRepository.findOneByGioHang_Id(username);
		
		return khachHangConvert.toDTO(khachHang);
	}

	@Override
	public void save(KhachHangDTO xe) {
		// TODO Auto-generated method stub
		KhachHang khachHang=khachHangConvert.toEntity(xe);
		khachHangRepository.save(khachHang);
	}

	@Override
	public KhachHangDTO findOneByIdEmail(String email) {
		// TODO Auto-generated method stub
		KhachHang khachHang=khachHangRepository.findOneByEmail(email);
		return khachHang!=null ? khachHangConvert.toDTO(khachHang):null;
	}

	
	public void createVerificationToken(KhachHangDTO khachHang, String token) {
		// TODO Auto-generated method stub
		VerificationTokenEntity verificationTokenEntity=new VerificationTokenEntity(token);
		TaiKhoanDTO taiKhoanDTO=khachHang.getTaiKhoan();
		taiKhoanDTO.setVerificationCode(verificationTokenEntity);
		GioHangDTO gioHang=new GioHangDTO();
		khachHang.setGioHang(gioHang);
		khachHang.setTaiKhoan(taiKhoanDTO);
		KhachHang kh=khachHangConvert.toEntity(khachHang);
		khachHangRepository.save(kh);
	}

	@Override
	public KhachHang registerNewKhachHangAccount(KhachHangDTO khachHangDTO) {
	
		if(khachHangRepository.findOneByEmail(khachHangDTO.getEmail())!=null)
		{
			throw new EntityExistsException("Email đã có người đăng kí "+ khachHangDTO.getEmail());
		}
		GioHangDTO gioHang=new GioHangDTO();
		khachHangDTO.setGioHang(gioHang);
		KhachHang khachHang=khachHangConvert.toEntity(khachHangDTO);
		
		return 	khachHangRepository.save(khachHang);
	}
    
    /*@Override
    public List<KhachHangDTO> findAll() {
        List<KhachHang> khachHang=khachHangRepository.findAll();
        return khachHangConvert.toDTOs(khachHang);
    }

    @Override
    public KhachHangDTO findOne(String id) {
       return null;
    }

    @Override
    public void save(KhachHangDTO xe) {
        KhachHang khachHang=khachHangConvert.toEntity(xe);
         khachHangRepository.save(khachHang);
        
        
    }

    @Override
    public void delete(String[] ids) {
       
    }

    @Override
    public void delete(String id) {
        khachHangRepository.delete(Integer.parseInt(id));
    }
*/
  /*  @Override
    public KhachHangDTO update(KhachHangDTO khachHangDTO) {
        KhachHang khachHang=khachHangConvert.toEntity(khachHangDTO);
        return khachHangConvert.toDTO(khachHangRepository.save(khachHang));
    }

   @Override
    public KhachHangDTO findOne(String ten,String so) {
        Specification<KhachHang> spec=KhachHangSpecification.hasNameAndSDT(ten, so);
        KhachHang khachHang=khachHangRepository.findOne(spec);
        return khachHangConvert.toDTO(khachHang);
	   return null;
   } */
    
}
