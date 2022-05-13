package com.mycompany.springmvchibernate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.BoNho;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.Chip;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Entity.Mau;
import com.mycompany.springmvchibernate.Entity.Ram;
import com.mycompany.springmvchibernate.Repositories.LoaiRepository;
import com.mycompany.springmvchibernate.Service.IBoNhoService;
import com.mycompany.springmvchibernate.Service.ICTSanPhamService;
import com.mycompany.springmvchibernate.Service.IChiTietDonDatHangService;
import com.mycompany.springmvchibernate.Service.IChipService;
import com.mycompany.springmvchibernate.Service.IHinhAnh;
import com.mycompany.springmvchibernate.Service.IMauService;
import com.mycompany.springmvchibernate.Service.IRamService;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
import com.mycompany.springmvchibernate.Service.Impl.SanPhamService;

@Controller
@RequestMapping(value="/quan-tri/product-detail")
public class ChiTietSanPhamController {
	
	@Autowired
	LoaiRepository loaiRepo;

	@Autowired
	IRamService ramService;
	
	@Autowired
	IChipService chipService;
	
	@Autowired
	IMauService mauService;
	
	@Autowired
	IBoNhoService boNhoService;

	@Autowired
	IHinhAnh hinhAnh;
	
	@Autowired
	ICTSanPhamService chiTietSanPhamService;
	
	@Autowired
	ISanPhamService sanPhamService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView pageDetail(@RequestParam(name="id",required = false) Integer idCTSP,
			@RequestParam(name = "type", required = true) String type,@RequestParam(name="sanPham") String idSanPham) {
		ModelAndView mav=new ModelAndView("/admin/product/productDetail");
		List<Ram> rams = ramService.findAll();
		List<BoNho> boNhos = boNhoService.findAll();
		List<Mau> maus = mauService.findAll();
		List<Chip> chips = chipService.findAll();
		
		mav.addObject("rams", rams);
		mav.addObject("boNhos", boNhos);
		mav.addObject("maus", maus);
		mav.addObject("chips", chips);
		if (idCTSP!=null && type.equals("edit")) {
			//SanPhamDTO sanPhamDTO = sanPhamService.findOneById(Integer.parseInt(id));
			ChiTietSanPhamDTO chiTietSanPhamDTO=chiTietSanPhamService.findOneById(idCTSP);
		
			mav.addObject("chiTietSanPham", chiTietSanPhamDTO);
			
			
			return mav;
		}  if (type.equals("add")&&idSanPham!=null) {
			mav.addObject("sanPham",idSanPham);
			return mav;
		}
		return mav;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addDetail(@RequestParam("product") Integer idSanPham,@ModelAttribute(name="chiTietSanPham") ChiTietSanPhamDTO chiTietSanPhamDTO) {
		sanPhamService.addChiTietSanPham(idSanPham, chiTietSanPhamDTO);
		return "redirect:/quan-tri/product-detail?type=add&sanPham="+idSanPham;
		
		
		
	}
}
