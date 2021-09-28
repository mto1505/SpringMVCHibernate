/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;

import com.mycompany.springmvchibernate.XeMay;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO2;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author MinhTo
 */
@Service
public interface IXeMayService {
	
    public void save(XeMayDTO2 xe);
    public void delete(String [] ids);
    public void delete(String id);
    public XeMayDTO2 update(XeMayDTO2 xe);
    public List<XeMayDTO>findAll(Pageable pageable);
    public List<XeMayDTO>findAll();
    int getTotalItem();
    XeMayDTO findById(String id);
    public XeMayDTO2 findOneByBienSo(String bienso);
    public List<XeMayDTO2> findAllByListBienSoAndTen(List bienSo,String name);
}
