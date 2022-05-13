package com.mycompany.springmvchibernate.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mycompany.springmvchibernate.Service.Convert.SanPhamConvert;
import com.mycompany.springmvchibernate.ValidationGroups.LoaiCheck;
import com.mycompany.springmvchibernate.ValidationGroups.SanPhamCheck;

public class LoaiDTO {
	
	@NotNull
	private String id;
	@NotNull(groups = LoaiCheck.class)
	private String ten;

	
	public LoaiDTO() {
		super();
	}



	public LoaiDTO(String id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}
