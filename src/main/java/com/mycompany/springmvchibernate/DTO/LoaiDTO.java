package com.mycompany.springmvchibernate.DTO;


public class LoaiDTO {

	private String id;

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
