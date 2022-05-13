package com.mycompany.springmvchibernate.Controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springmvchibernate.Controller.SanPhamNotFoundException;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Repositories.SanPhamRepository;
import com.mycompany.springmvchibernate.Service.IDanhMucService;
import com.mycompany.springmvchibernate.Service.ISanPhamService;

@Controller("webController")
public class HomeController {
	@Autowired
	ISanPhamService sanPhamService;
	@Autowired
	SanPhamRepository sanPhamRepository;
	
	@Autowired
	private IDanhMucService danhMucService;
	
	
	
	
	
	@RequestMapping("/home")
	public ModelAndView showPageBestSeller()
	{
		ModelAndView mav=new ModelAndView("/index");
		List<Loai> danhMuc=danhMucService.findAll();
		mav.addObject("categories", danhMuc);	
		
		List<ChiTietSanPhamDTO> sanPhams=sanPhamService.findBySellMore(1);
		
		mav.addObject("listSanPhamPage", sanPhams);
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/testException")
	public String foundSanPhan(@RequestParam(required = true) String id,Model model) throws SanPhamNotFoundException// throws Exception
	{
		/*RedirectView redirectView = new RedirectView("/");*/
		if (id.equals("123")) {
			throw new SanPhamNotFoundException(Integer.valueOf(id));
		} 
		/*}
		catch(Exception e)
		{
			model.addAttribute("message",e.getMessage());
			return "errorBusiness";
		}*/
		return "web/product/home";
	}
	
	@RequestMapping(value="/exceptionBussiness",method=RequestMethod.GET)
	public ModelAndView exceptionBussiness()
	{
		ModelAndView view=new ModelAndView("/login");
		return view;
	}
	
	 /*@ExceptionHandler(SanPhamNotFoundException.class) 
	  public ModelAndView handleSanPhamNotFoundException(HttpServletRequest request,Exception ex) {
	  ModelAndView mav=new ModelAndView("errorBusiness"); 
	  mav.addObject("exception", ex);
	  mav.addObject("url",request.getRequestURI());
	  mav.addObject("message",ex.getMessage());
	  return mav; 
	  }*/
	 
	// @ExceptionHandler(SanPhamNotFoundException.class)//linh hoạt hơn  @ResponseStatus
	//  @ResponseStatus(HttpStatus.NOT_FOUND) // kết hợp 2 annotion để cho chi tiết hơn 
	//chỉ cần @ExceptionHandler là đủ
	  public ResponseEntity<SanPham> handleNoSuchElementFoundException(
			  SanPhamNotFoundException exception
	  ) {
		SanPham sp=new SanPham();
		sp.setTen("Iphone");
	    return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(sp);
	  }
	  @RequestMapping(value="/testSanPham")
	 public void testSanPhamBanChay()
	 {
		  List listResult= sanPhamRepository.findBySellMore(5);
		  System.out.println(listResult.size());
	 }
	  
	/*@RequestMapping(value="/dang-nhap")
	public ModelAndView webLogin(@RequestParam(value="sessionTimeout",required=false) String sessionTimeout)
	{
		ModelAndView mav=new ModelAndView("/login");
		return mav;
	}
	@RequestMapping(value="/dang-nhap",method=RequestMethod.POST)
	public ModelAndView processLogin( )
	{
		
	}
	@RequestMapping(value="/accessDenied")
	public ModelAndView errorAccessDenied()
	{
		ModelAndView mav=new ModelAndView("/login");
		return mav;
	}
	@RequestMapping(value="/")
	public ModelAndView home()
	{
		ModelAndView mav=new ModelAndView("/web/home");
		return mav;
		
	}*/
	
}
