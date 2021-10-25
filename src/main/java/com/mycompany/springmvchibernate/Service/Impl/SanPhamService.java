package com.mycompany.springmvchibernate.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
import com.mycompany.springmvchibernate.Service.Convert.SanPhamConvert;

@Service
public class SanPhamService implements ISanPhamService{
	
	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	SanPhamConvert sanPhamConvert;
	
	@Override
	
	public void save(SanPhamDTO xe) {
		SanPham sanPhamDTO=sanPhamConvert.toEntity(xe);
		sanPhamRepository.save(sanPhamDTO);	
	}

	@Override
	public void delete(Integer[] ids) {
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
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
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
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

}	
