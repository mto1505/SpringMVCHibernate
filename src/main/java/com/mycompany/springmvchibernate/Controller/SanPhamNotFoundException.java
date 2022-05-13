package com.mycompany.springmvchibernate.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="SanPham not found")
public class SanPhamNotFoundException extends Exception{

	public SanPhamNotFoundException(int id) {
		super("SanPham " +id);
		// TODO Auto-generated constructor stub
	}

}
