/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;

import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO2;
import com.mycompany.springmvchibernate.Entity.Mau;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author MinhTo
 */
public interface IMauService {

    List<Mau> findAll();

    Mau findOne(String id);

    public void save(Mau xe);

    public void delete(String[] ids);

    public void delete(String id);

    public Mau update(Mau xe);
    //  public List<XeMayDTO>findAll(Pageable pageable);
    public Mau findOne(String ten,String sdt);

}
