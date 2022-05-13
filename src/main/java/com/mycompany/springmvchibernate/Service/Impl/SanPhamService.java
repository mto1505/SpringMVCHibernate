package com.mycompany.springmvchibernate.Service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvchibernate.AOP.TrackTime;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Repositories.HinhAnhRepository;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
import com.mycompany.springmvchibernate.Service.Convert.ChiTietSanPhamConvert;
import com.mycompany.springmvchibernate.Service.Convert.SanPhamConvert;

@Service
@Transactional
@Scope(proxyMode =ScopedProxyMode.INTERFACES)
public class SanPhamService implements ISanPhamService{
	
	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	SanPhamConvert sanPhamConvert;
	@Autowired
	ChiTietSanPhamConvert chiTietSanPhamConvert;
	@Autowired
	HinhAnhRepository hinhAnhRepo;
	
	@Override
	public void save(SanPhamDTO xe) {
		SanPham sanPhamDTO=sanPhamConvert.toEntity(xe);
		sanPhamRepository.save(sanPhamDTO);	
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void delete(Integer[] ids) {
		List<Integer> list=Arrays.asList(ids);
		sanPhamRepository.deleteByIdIn(list);
		//sanPhamRepository.customDeleteByIds(list);
		sanPhamRepository.print();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		sanPhamRepository.delete(id);
		
	}

	@Override
	public SanPhamDTO update(SanPhamDTO xe) {
		// TODO Auto-generated method stub
		SanPham sanPham= sanPhamConvert.toEntity(xe);
		sanPhamRepository.save(sanPham);
		return sanPhamConvert.toDTO(sanPham);
		
	}

	@Override
	public List<SanPhamDTO> findAll(Pageable pageable) {
		return null;

	}

	@Override
	public List<SanPhamDTO> findAll() {
		// TODO Auto-generated method stub
				List<SanPham> listSp=sanPhamRepository.findAllAndFetchChiTiet();
				return sanPhamConvert.toDTOs(listSp);
	}

	@Override
	@TrackTime
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public SanPhamDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPhamDTO findOneById(Integer id) {
		// TODO Auto-generated method stub
		SanPham s=sanPhamRepository.findOne(id);
		return sanPhamConvert.toDTO(s);
		
	}

	@Override
	public List<SanPhamDTO> findAllByListBienSoAndTen(List bienSo, String name) {
		//TODO Auto-generated method stub
		return null;
	}

	@Override
	public SanPhamDTO findByIdAndFetchChiTietEagerly(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public	List<SanPhamDTO> findAllAndFetchChiTietAnhHinhAnhEagerly(Pageable pageable) {
		// TODO Auto-generated method stub
		/*List<SanPhamDTO> listSp=sanPhamRepository.findAllAndFetchChiTiet();
		return listSp;*/
		//return sanPhamConvert.toDTOs(listSp);
		return null;
	}

	@Override
	public List<SanPhamDTO> findByTenLoai(String loai) {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams=sanPhamRepository.findByLoaiTen(loai);
		return sanPhamConvert.toDTOs(sanPhams);
	}

	@Override
	public List<SanPhamDTO> findByTenLoaiAndFetchChiTiet(String loai) {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams=sanPhamRepository.findByTenLoaiAndFetchChiTiet(loai);
		return sanPhamConvert.toDTOs(sanPhams);
		
	}

	@Override
	public void addChiTietSanPham(Integer id, ChiTietSanPhamDTO ctsp) {
		// TODO Auto-generated method stub
		ChiTietSanPham chiTietSanPham=chiTietSanPhamConvert.toEntity(ctsp);
		sanPhamRepository.addChiTietSanPham(id, chiTietSanPham);
	}

	@Override
	public List<ChiTietSanPhamDTO> findBySellMore(int soLuongMua) {
		// TODO Auto-generated method stub
		List chiTietSanPhams=sanPhamRepository.findBySellMore(soLuongMua);
		int i=0;
		List<ChiTietSanPham>chiTietSanPhams2=new ArrayList<ChiTietSanPham>();
		for (int j = 0; j < chiTietSanPhams.size(); j++) {
			
		
			Object[] manager = (Object[]) chiTietSanPhams.get(j);
			SanPham sanPham=(SanPham) manager[1];
			List<HinhAnhSP> hinhAnhSPs=hinhAnhRepo.findBySanPham_Id(sanPham.getId());
			ChiTietSanPham chiTietSanPham=(ChiTietSanPham) manager[0];
			sanPham.setHinhAnhSps(hinhAnhSPs);
			chiTietSanPham.setSanPham(sanPham);
			
			chiTietSanPhams2.add(chiTietSanPham);
			
		}
		
		

		List<ChiTietSanPhamDTO> chiTietSanPhamDTOs=chiTietSanPhamConvert.toDTOs(chiTietSanPhams2);
		return chiTietSanPhamDTOs;
	}

	@Override
	public List<SanPhamDTO> findByTenLoaiAndFetchChiTietAndHaveName(String tenLoai, String name) {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams=sanPhamRepository.findByTenLoaiAndFetchChiTietAndHaveName(tenLoai, name);
		return sanPhamConvert.toDTOs(sanPhams);
		
	}

	@Override
	public List<SanPhamDTO> findAllSanPham() {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams=sanPhamRepository.findSanPhamAndDetail(1);
		return sanPhamConvert.toDTOs(sanPhams);
	}

	@Override
	public List<SanPhamDTO> findSanPhamAndDetail(int id) {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams=sanPhamRepository.findSanPhamAndDetail(id);
		return sanPhamConvert.toDTOs(sanPhams);
	}

}	
