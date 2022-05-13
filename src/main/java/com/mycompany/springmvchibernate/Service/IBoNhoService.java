/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;


import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.Entity.BoNho;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author MinhTo
 */
public interface IBoNhoService {

    List<BoNho> findAll();

    BoNho findOne(String id);

    public void save(BoNho xe);

    public void delete(String[] ids);

    public void delete(String id);

    public BoNho update(BoNho xe);
    //  public List<XeMayDTO>findAll(Pageable pageable);
    public BoNho findOne(String ten,String sdt);

}
