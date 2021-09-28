/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;

import com.mycompany.springmvchibernate.KhachHang;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO2;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author MinhTo
 */
public interface IKhachHangService {

    List<KhachHangDTO> findAll();

    KhachHangDTO findOne(String id);

    public void save(KhachHangDTO xe);

    public void delete(String[] ids);

    public void delete(String id);

    public KhachHangDTO update(KhachHangDTO xe);
    //  public List<XeMayDTO>findAll(Pageable pageable);
    public KhachHangDTO findOne(String ten,String sdt);

}
