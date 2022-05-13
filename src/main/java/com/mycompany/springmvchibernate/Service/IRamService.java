/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;


import com.mycompany.springmvchibernate.DTO.RamDTO;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.Entity.Ram;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author MinhTo
 */
public interface IRamService {

    List<Ram> findAll();

    Ram findOne(String id);

    public void save(Ram xe);

    public void delete(String[] ids);

    public void delete(String id);

    public Ram update(Ram xe);
    //  public List<XeMayDTO>findAll(Pageable pageable);
    public Ram findOne(String ten,String sdt);

}
