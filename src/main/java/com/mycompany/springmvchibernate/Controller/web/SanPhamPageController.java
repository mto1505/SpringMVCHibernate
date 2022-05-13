package com.mycompany.springmvchibernate.Controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Service.IDanhMucService;
import com.mycompany.springmvchibernate.Service.ISanPhamService;

@Controller
public class SanPhamPageController {

	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	private IDanhMucService danhMucService;
	@RequestMapping("/category/{loai}")
	public ModelAndView pageSanPham(@PathVariable("loai") String tenLoai)
	{
		ModelAndView mav=new ModelAndView("/web/home");
		List<SanPhamDTO> sanPhams=sanPhamService.findByTenLoaiAndFetchChiTiet(tenLoai);
		//mav.addObject("categories", danhMuc);	
	List<ChiTietSanPhamDTO> chiTietSanPhams=sanPhamService.findBySellMore(1);
		
		mav.addObject("listCTSanPhamPage", chiTietSanPhams);
		
		mav.addObject("listSanPhamPage", sanPhams);
		return mav;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView timKiemSanPham(@RequestParam("tenLoai") String tenLoai,@RequestParam("searchField") String searchField)
	{
		ModelAndView mav=new ModelAndView("/web/home");
		
		List<SanPhamDTO> sanPhams=sanPhamService.findByTenLoaiAndFetchChiTietAndHaveName(tenLoai, searchField);
		//mav.addObject("categories", danhMuc);	
		List<ChiTietSanPhamDTO> chiTietSanPhams=sanPhamService.findBySellMore(1);
		
		mav.addObject("listCTSanPhamPage", chiTietSanPhams);
		
		mav.addObject("listSanPhamPage", sanPhams);
		return mav;
	}

}
