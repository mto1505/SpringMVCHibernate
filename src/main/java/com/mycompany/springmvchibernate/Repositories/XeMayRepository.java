/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Repositories;


import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;

import com.mycompany.springmvchibernate.DTODemo.XeMayView;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author MinhTo
 */
/*public interface XeMayRepository extends JpaRepository<XeMay, String>, JpaSpecificationExecutor<XeMay> {

    @Query("SELECT new com.mycompany.springmvchibernate.DTO.XeMayDTO(x.bienSo,x.tenxe,kh.ten,l.tenloai) FROM XeMay as x"
            + " join x.khachHang as kh "
            + "join x.loaiXe as l")
    List<XeMayDTO> findAllCustom(Pageable pageable);

    //XeMayView findOneBybienSo(String bienso);
    XeMay findOneBybienSo(String bienso);

    @Override
    List<XeMay> findAll(Specification<XeMay> spec);
    
}
*/