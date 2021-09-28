/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Impl;

import com.mycompany.springmvchibernate.KhachHang;

import com.mycompany.springmvchibernate.Service.Convert.XeMayConvert;
import com.mycompany.springmvchibernate.Service.IKhachHangService;
import com.mycompany.springmvchibernate.Service.IXeMayService;
import com.mycompany.springmvchibernate.Specification.XeSpecification;
import com.mycompany.springmvchibernate.XeMay;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO2;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
/*@Component("xeMayService")*/
public class XeMayService // implements IXeMayService
{
}
  /*  @Autowired
    private XeMayRepository xeMayRepository;
    @Autowired
    private XeMayConvert xeMayConvert;
   

    @Override
    public void save(XeMayDTO2 xe) {
        XeMay xeMay = xeMayConvert.toEntity(xe);
        Optional.ofNullable(xeMayRepository.save(xeMay)).orElseThrow(() -> {
            return new RuntimeException("save object failed"); //To change body of generated lambdas, choose Tools | Templates.
        });
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            xeMayRepository.delete(id);
        }
    }

    @Override
    public List<XeMayDTO> findAll(Pageable pageable) {
        return xeMayRepository.findAllCustom(pageable);
    }

    @Override
    public int getTotalItem() {
        return (int) xeMayRepository.count();
    }

    @Override
    public XeMayDTO findById(String id) {
        XeMay xeMay = xeMayRepository.findOneBybienSo(id);
        return xeMayConvert.toDTO(xeMay);
    }

    @Override
    public XeMayDTO2 findOneByBienSo(String bienso) {
        XeMay xeMay = xeMayRepository.findOneBybienSo(bienso);
        return xeMayConvert.toDTO2(xeMay);
    }

    @Override
    public List<XeMayDTO> findAll() {
        List<XeMay> listXeMay = xeMayRepository.findAll();
        return xeMayConvert.toDTOs(listXeMay);
    }

    @Override
    public List<XeMayDTO2> findAllByListBienSoAndTen(List bienSo, String name) {
        List<XeMayDTO2> listXeMay = new ArrayList<>();
        Specification spec = Specifications.where(XeSpecification.hasBienSoIn(bienSo)).and(XeSpecification.hasTenXe(name));
        listXeMay = xeMayConvert.toDTO2s(xeMayRepository.findAll(spec));
        return listXeMay;
    }

    @Override
    public void delete(String id) {
//        XeMay xeMay=new XeMay();
//        XeMayDTO xeMayDTO=findById(id);
//        xeMay=xeMayConvert.toEntity(xeMayDTO);
//        xeMayRepository.delete(findById(id));
        xeMayRepository.delete(id);
    }

    @Override
    public XeMayDTO2 update(XeMayDTO2 xe) {
        //Kiem tra thông tin khách hang;
        
        XeMay xeMay=xeMayConvert.toEntity(xe);
        KhachHang khachHang=xeMay.getKhachHang();
        //khachHangService.update(khachHang);
        
        XeMay xeMayNew=xeMayRepository.save(xeMay);
        return xeMayConvert.toDTO2(xeMayNew);
    }

}
*/