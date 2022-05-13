package com.mycompany.springmvchibernate.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;


import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;

public interface IChiTietDonDatHangService {
	public void save(ChiTietDonDatHang xe);	
    public void delete(Integer [] ids);    
    public void delete(Integer id);
    public ChiTietDonDatHang update(ChiTietDonDatHang xe);
    public List<ChiTietDonDatHang>findAll(Pageable pageable);
    public List<ChiTietDonDatHang>findAll();
    int getTotalItem();
    List<ChiTietDonDatHang> findByIdIdDDH(int id);
    public ChiTietDonDatHang findOneById(Integer id);
    
}
