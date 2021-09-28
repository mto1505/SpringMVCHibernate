/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Impl;

import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConvert;
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
/*@Component*/
public class KhachHangService 
//implements IKhachHangService
{
   /* @Autowired
    KhachHangRepository khachHangRepository;
    
    @Autowired
    KhachHangConvert khachHangConvert;
    @Override
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

    @Override
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
