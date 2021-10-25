package com.mycompany.springmvchibernate.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHang;
import com.mycompany.springmvchibernate.Entity.DonDatHang;
import com.mycompany.springmvchibernate.Service.IChiTietDonDatHangService;
import com.mycompany.springmvchibernate.Service.IDonDatHangService;

@Controller
@RequestMapping(value = "/quan-tri/order")
public class DonDatHangController {

	@Autowired
	IDonDatHangService donDatHangService;
	@Autowired
	IChiTietDonDatHangService chiTietDonDatHangService;

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public ModelAndView danhSachDondatHang(@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "id") Integer id, @RequestParam(name = "limit", defaultValue = "5") Integer limit,
			@RequestParam(name = "sortName", defaultValue = "tinhTrang") String sortName,@RequestParam(name="trangThai",required=true) Integer trangThai) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/order/list");
		Pageable pageable=new PageRequest(page-1, limit);
		List<DonDatHangDTO> listDondathang = new ArrayList<DonDatHangDTO>();
		int totalItem;
		if(trangThai!=null&&trangThai==0)
		{
			DonDatHang ddh=new DonDatHang();
			ddh.setTinhTrang(trangThai);
			ExampleMatcher matcher=ExampleMatcher.matching().withIgnorePaths("id");
			Example<DonDatHang> example=Example.of(ddh,matcher);
			totalItem=donDatHangService.getTotalItem(example);
			listDondathang = donDatHangService.findAll(example,pageable);
			modelAndView.addObject("trangThai",trangThai);
		}
		else {
		totalItem=donDatHangService.getTotalItem();
		listDondathang = donDatHangService.findAll(pageable);
		modelAndView.addObject("trangThai",1);
		}
		int totalPage=(int) Math.ceil((double)totalItem/(double)limit);
		int currentPage=page;
		modelAndView.addObject("listOrder", listDondathang);
		modelAndView.addObject("currentPage",currentPage);
		modelAndView.addObject("totalPage",totalPage);
		
		if (id == null) { 
			return modelAndView;
		}
		else {
			List<ChiTietDonDatHang> detailOrders=chiTietDonDatHangService.findByIdIdDDH(id);
			modelAndView.addObject("detailOrders",detailOrders);
			return modelAndView;

		}
		

	}
}
