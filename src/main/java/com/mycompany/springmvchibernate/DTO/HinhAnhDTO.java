package com.mycompany.springmvchibernate.DTO;

public class HinhAnhDTO {
	private String id;
	private String hinhAnh;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public HinhAnhDTO(String id, String hinhAnh) {
		super();
		this.id = id;
		this.hinhAnh = hinhAnh;
	}
	
}
