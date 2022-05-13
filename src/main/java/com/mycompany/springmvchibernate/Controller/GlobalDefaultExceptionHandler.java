package com.mycompany.springmvchibernate.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	public static final String DEFAULT_VIEW_ERROR="error";
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e,HttpServletResponse response) throws Exception
	{
		ModelAndView mav=new ModelAndView("/404");
		//find annotation type on class given 
		if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null)
		{
			throw e;
		}
		mav.addObject("exception",e);
		mav.addObject("url",request.getRequestURL());
	    mav.setViewName(DEFAULT_VIEW_ERROR);
	  //  response.setStatus(400);
		return mav;
		
	}
	@ExceptionHandler(SanPhamNotFoundException.class)
	public ModelAndView SanPhamErrorHandler(HttpServletRequest request,Exception e) throws Exception
	{
		ModelAndView mav=new ModelAndView("/404");
		//find annotation type on class given 
		/*if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null)
		{
			throw e;
		}*/
		mav.addObject("exception",e);
		mav.addObject("url",request.getRequestURL());
	    mav.setViewName(DEFAULT_VIEW_ERROR);
		return mav;
		
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		//logger.error("IOException handler executed");
		//returning 404 error code
	}
	@ExceptionHandler(SizeLimitExceededException.class)
	public ModelAndView maxUploadSizeExceededErrorHandler(HttpServletRequest request,Exception e,HttpServletResponse response) throws Exception
	{
		ModelAndView mav=new ModelAndView("/404");
		//find annotation type on class given 
		if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null)
		{
			throw e;
		}
		mav.addObject("exception",e);
		mav.addObject("url",request.getRequestURL());
	    mav.setViewName(DEFAULT_VIEW_ERROR);
	  //  response.setStatus(400);
		return mav;
		
	}
	
}
