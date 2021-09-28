package com.mycompany.springmvchibernate.Controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("webController")
public class HomeController {
	
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
