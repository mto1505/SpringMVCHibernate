/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Controller;

import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;
import com.mycompany.springmvchibernate.Dao.SanPhamDao;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Service.IXeMayService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhTo
 */
@Controller

public class HomeController {
	
	@Autowired
	private SanPhamDao sanPhamDao;
	
	@RequestMapping(value="/quan-tri/trang-chu",method=RequestMethod.GET)
	public ModelAndView trangChu()
	{
	
		ModelAndView view=new ModelAndView("/admin/home");
		List<SanPham>listSp=sanPhamDao.findAll();
		System.out.println(listSp.size());
		return view;
		
	}
	
   /* @Autowired
    IXeMayService xeMayService;
    
    @RequestMapping(value = {"/quan-tri/xe-may/danh-sach"}, method = RequestMethod.GET)
    public ModelAndView helloWord(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = true) int limit, HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("/admin/car/listcar");
        int currentPage = page;
        int pagelimit = limit;
        int totalItem = xeMayService.getTotalItem();
        
        mav.addObject("page", currentPage);
        mav.addObject("limit", pagelimit);
        mav.addObject("totalItem", totalItem);
        mav.addObject("totalPage", Math.ceil(totalItem / pagelimit));
        
        Pageable pageable = new PageRequest(currentPage - 1, pagelimit);

       
        List<XeMayDTO> listXe = (List<XeMayDTO>) xeMayService.findAll(pageable);

        mav.addObject("listXeMay", listXe);
        return mav;
    }*/

//    @GetMapping("api/xe-may") 
//    public ResponseEntity<List<XeMayDTO>> findAll()
//    {
//        //List<XeMayDTO> list=xeMayRepository
//        return ResponseEntity.ok().body(xeMayRepository.findAllCustom((Pageable) new PageRequest(0, 5)));
//    }
}
