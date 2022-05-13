package com.mycompany.springmvchibernate.Controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.HinhAnhDTO;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
import com.mycompany.springmvchibernate.Service.IChiTietSanPhamService;
import com.mycompany.springmvchibernate.Service.IHinhAnh;

@Controller
public class SanPhamDetailController {
	@Autowired
	ICTSanPhamService ctSanPhamService;
 	@Autowired
 	IHinhAnh hinhAnhService;
 	
 	@RequestMapping("/apple/{id}")
	public ModelAndView sanPham(@PathVariable("id") Integer id)
	{	
 		
		ChiTietSanPhamDTO ctsp=ctSanPhamService.findOneById(id);
		ModelAndView mav=new ModelAndView("/web/product/productDetail");
		List<HinhAnhSP> hinhAnhs=hinhAnhService.findAllByIdSanPham(ctsp.getSanPham().getId());
		List<ChiTietSanPhamDTO> ctsps=ctSanPhamService.findAllByIdSanPham(ctsp.getSanPham().getId());
		mav.addObject("ctsp",ctsp);
		mav.addObject("ctsps",ctsps);
		mav.addObject("hinhAnhs", hinhAnhs);
		
		return mav;
	}
 	
 	@RequestMapping("/checkout")
	public ModelAndView showCheckout()
	{	

		ModelAndView mav=new ModelAndView("/web/checkout");

		return mav;
	}

	
	
}
