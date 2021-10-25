package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.DonDatHang;

public interface IDonDatHangService {

	public void save(DonDatHangDTO xe);	
    public void delete(Integer [] ids);    
    public void delete(Integer id);
    public DonDatHangDTO update(DonDatHangDTO xe);
    public List<DonDatHangDTO>findAll(Pageable pageable);
    public List<DonDatHangDTO>findAll(Example<DonDatHang> ex,Pageable pageable);
    public List<DonDatHangDTO>findAll();
    public int getTotalItem();
    public int getTotalItem(Example<DonDatHang> ex);
    DonDatHangDTO findById(String id);
    public DonDatHangDTO findOneById(Integer id);
    public int count();
}	

