package com.mycompany.springmvchibernate.Controller.web;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.ToIntFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.springmvchibernate.DTO.ChiTietDonDatHangDTO;
import com.mycompany.springmvchibernate.DTO.ChiTietGioHangDTO;
import com.mycompany.springmvchibernate.DTO.DonDatHangDTO;
import com.mycompany.springmvchibernate.DTO.KhachHangDTO;
import com.mycompany.springmvchibernate.DTO.UserDetailCustom;
import com.mycompany.springmvchibernate.Entity.KhachHang;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
import com.mycompany.springmvchibernate.Service.IChiTietDonDatHangService;
import com.mycompany.springmvchibernate.Service.IChiTietGioHangService;
import com.mycompany.springmvchibernate.Service.IDonDatHangService;
import com.mycompany.springmvchibernate.Service.IKhachHangService;

@Controller
@RequestMapping("/order")
public class DatHangController {
	
	@Autowired
	IDonDatHangService donDatHangService;
	@Autowired
	IChiTietDonDatHangService chiTietDonDatHangService;
	@Autowired
	IChiTietGioHangService chiTietGioHangService;
	@Autowired
	ICTSanPhamService chiTietSanPhamService;
	@Autowired
	IKhachHangService khachHangService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String processOrder(@ModelAttribute("order") DonDatHangDTO donDatHang,Authentication authentication)
	{	
		
		//get id gioHang
		UserDetailCustom user=(UserDetailCustom) authentication.getPrincipal();
		int idGioHang=user.getIdGH();
		//get khachHang
		KhachHangDTO khachHang=khachHangService.findOneByIdGioHang(user.getIdGH());
		
		List<ChiTietGioHangDTO> chiTietGioHangs=chiTietGioHangService.findByidIdGh(idGioHang);
			DonDatHangDTO donDatHangDTOs=new DonDatHangDTO();
			donDatHangDTOs.setChiTietDonDatHangs(new ArrayList<ChiTietDonDatHangDTO>());
			donDatHangDTOs.setDiaChi(donDatHang.getDiaChi());
			donDatHangDTOs.setChuThich(donDatHang.getChuThich());
			donDatHangDTOs.setDiaChi(donDatHang.getDiaChi());
			Date date=new Date();
			donDatHangDTOs.setThoiGian(new Timestamp(date.getTime()));
			for(ChiTietGioHangDTO ctgh:chiTietGioHangs)
		{
			ChiTietDonDatHangDTO chiTietDonDatHangDTO=new ChiTietDonDatHangDTO();
			chiTietDonDatHangDTO.setIdIdCtsp(ctgh.getIdIdCtsp());
			chiTietDonDatHangDTO.setSoLuong(ctgh.getSoLuong());
			donDatHangDTOs.setKhachHang(khachHang);
			
			donDatHangDTOs.addChiTietDonDatHang(chiTietDonDatHangDTO);
		}
		donDatHangService.save(donDatHangDTOs);
		System.out.println(donDatHang);
		return "redirect:/home";
	}
}
