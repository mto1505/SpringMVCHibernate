package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.Id;

public class ChipDTO {
	
	private String id;

	private String ten;

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

	public ChipDTO() {
		super();
	}

	public ChipDTO(String id, String name) {
		super();
		this.id = id;
		this.ten = name;
	}
	
}
