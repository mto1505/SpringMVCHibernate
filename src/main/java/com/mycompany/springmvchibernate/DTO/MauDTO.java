package com.mycompany.springmvchibernate.DTO;

public class MauDTO {

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
	public MauDTO() {
		super();
	}
	public MauDTO(String id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	
}
