/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;

import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;

import com.mycompany.springmvchibernate.Entity.Loai;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author MinhTo
 */
public interface IDanhMucService {

    List<Loai> findAll();

    Loai findOne(String id);

    public void save(Loai xe);

    public void delete(String[] ids);

    public void delete(String id);

    public Loai update(Loai ob);
    //  public List<XeMayDTO>findAll(Pageable pageable);
 
    

}
