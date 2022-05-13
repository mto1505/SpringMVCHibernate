/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;


import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO2;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.Entity.KhachHang;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author MinhTo
 */
public interface IKhachHangService {

   /* List<KhachHangDTO2> findAll();

    KhachHangDTO2 findOne(String id);

    public void save(KhachHangDTO2 xe);

    public void delete(String[] ids);

    public void delete(String id);

    public KhachHangDTO2 update(KhachHangDTO2 xe);
    //  public List<XeMayDTO>findAll(Pageable pageable);
    public KhachHangDTO2 findOne(String ten,String sdt);*/
	
	 List<KhachHangDTO> findAll();

	    KhachHangDTO findOne(String id);

	    public void save(KhachHangDTO xe);
	    
	  

	    public void delete(String[] ids);

	    public void delete(String id);

	    public KhachHangDTO update(KhachHangDTO xe);
	    //  public List<XeMayDTO>findAll(Pageable pageable);
	    public KhachHangDTO findOne(String ten,String sdt);
	    
	    public KhachHangDTO findOneByIdGioHang(int id);
	    public KhachHangDTO findOneByIdEmail(String email);
	    
	    public KhachHang registerNewKhachHangAccount(KhachHangDTO khachHangDTO);
	    
    

}
