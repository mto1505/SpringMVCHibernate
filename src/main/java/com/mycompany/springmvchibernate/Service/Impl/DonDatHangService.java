package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHangPK;
import com.mycompany.springmvchibernate.Entity.DonDatHang;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Repositories.DonDatHangRepository;
import com.mycompany.springmvchibernate.Service.IDonDatHangService;
import com.mycompany.springmvchibernate.Service.Convert.DonDatHangConvert;
import com.mycompany.springmvchibernate.Service.Convert.KhachHangConverter;

@Service
public class DonDatHangService implements IDonDatHangService {
	
	@Autowired
	DonDatHangRepository donDatHang;
	@Autowired
	DonDatHangConvert ddhConvert;
	@Autowired
	KhachHangConverter khachHangConv;
	@Override
	public void save(DonDatHangDTO xe) {
		DonDatHang ddh=ddhConvert.toEntity(xe);
		/*List<ChiTietDonDatHang> listDDH=ddh.getChiTietDonDatHangs();
		for(ChiTietDonDatHang donHang:listDDH)
		{	
			ChiTietDonDatHangPK chiTietDonDatHangPK=new ChiTietDonDatHangPK();
			chiTietDonDatHangPK.setIdCtsp(donHang.getId().getIdCtsp());
			donHang.setId(chiTietDonDatHangPK);
			ddh.addChiTietDonDatHang(donHang);
		}*/
		/*KhachHang khachHang=khachHangConv.toEntity(xe.getKhachHang());
		ddh.setKhachHang(khachHang);*/
		donDatHang.save(ddh);
		
	}

	@Override
	public void delete(Integer[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DonDatHangDTO update(DonDatHangDTO xe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DonDatHangDTO> findAll(Pageable pageable) {
		Page<DonDatHang> orderPages=donDatHang.findAll(pageable);
		List<DonDatHang> orders=orderPages.getContent();
		return ddhConvert.toDTOs(orders);
	}

	@Override
	public List<DonDatHangDTO> findAll() {
		List<DonDatHang> orders=donDatHang.findAll();
		return ddhConvert.toDTOs(orders);
	}
	
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) donDatHang.count();
	}

	@Override
	public DonDatHangDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DonDatHangDTO findOneById(Integer id) {
		// TODO Auto-generated method stub
		DonDatHang ddh=donDatHang.findOne(id);
		
		return ddhConvert.toDTO(ddh);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalItem(Example<DonDatHang> ex) {
		// TODO Auto-generated method stub
		return (int) donDatHang.count(ex);
	}

	@Override
	public List<DonDatHangDTO> findAll(Example<DonDatHang> ex, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<DonDatHang> orderPages=donDatHang.findAll(ex,pageable);
		List<DonDatHang> orders=orderPages.getContent();
		return ddhConvert.toDTOs(orders);
	}

}
