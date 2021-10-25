package com.mycompany.springmvchibernate.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="SanPham not found")
public class SanPhamNotFoundException extends Exception{

	public SanPhamNotFoundException(int id) {
			super("SanPhamNotFoundException" +id);
		// TODO Auto-generated constructor stub
	}
	 	

}
