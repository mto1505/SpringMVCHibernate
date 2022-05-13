package com.mycompany.springmvchibernate.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView danhSachDondatHang(@RequestParam(name = "page", defaultValue = "1",required=false) Integer page,
			@RequestParam(name = "id",required=false) Integer id, @RequestParam(name = "limit", defaultValue = "10",required=false) Integer limit,
			@RequestParam(name = "sortName", defaultValue = "tinhTrang",required=false) String sortName,@RequestParam(name="trangThai",required=false,defaultValue="0") @Min(value=0) @Max(value=1) Integer trangThai) {
		
		ModelAndView modelAndView = new ModelAndView("/admin/order/list");
		Pageable pageable=new PageRequest(page-1, limit);
		List<DonDatHangDTO> listDondathang = new ArrayList<DonDatHangDTO>();
		int totalItem;
		DonDatHang ddh=new DonDatHang();
		if(trangThai==0)
		{
			ddh.setTinhTrang(trangThai);
			ExampleMatcher matcher=ExampleMatcher.matching().withIgnorePaths("id");
			Example<DonDatHang> example=Example.of(ddh,matcher);
			totalItem=donDatHangService.getTotalItem(example);
			listDondathang = donDatHangService.findAll(example,pageable);
			modelAndView.addObject("trangThai",trangThai);
		}
		else {
		ddh.setTinhTrang(1);
		ExampleMatcher matcher=ExampleMatcher.matching().withIgnorePaths("id");
		Example<DonDatHang> example=Example.of(ddh,matcher);	
		totalItem=donDatHangService.getTotalItem(example);
		listDondathang = donDatHangService.findAll(example,pageable);
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
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public String acceptOrder(@RequestParam("idDonDatHang") @Min(value=0) Integer idDonDatHang)
	{
		//
		DonDatHangDTO donDatHangDTO=donDatHangService.findOneById(idDonDatHang);
		if(donDatHangDTO!=null)
		{
			donDatHangDTO.setTinhTrang(1);
			donDatHangService.save(donDatHangDTO);
		}
		else {
			throw new EntityNotFoundException("Đơn đặt hàng không tồn tại");
		}
		return "redirect:/quan-tri/order/danh-sach?page=1";
	}

}
