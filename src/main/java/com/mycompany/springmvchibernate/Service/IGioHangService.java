package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.GioHangDTO;

public interface IGioHangService {
	
	public void save(GioHangDTO xe);	
    public void delete(Integer [] ids);    
    public void delete(Integer id);
    public GioHangDTO update(GioHangDTO xe);
    public List<GioHangDTO>findAll(Pageable pageable);
    public List<GioHangDTO>findAll();
    int getTotalItem();
    public void addChiTietGioHang(int idGioHang,ChiTietGioHangDTO chiTietGioHangDTO);
   
}
