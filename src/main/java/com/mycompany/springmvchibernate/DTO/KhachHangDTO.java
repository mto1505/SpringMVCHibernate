package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.Id;

public class KhachHangDTO {
	
	private int id;

	
	private String diaChi;

	
	private String email;

	
	private String hoVaTenDem;

	
	private String soDienThoai;


	private String ten;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHoVaTenDem() {
		return hoVaTenDem;
	}


	public void setHoVaTenDem(String hoVaTenDem) {
		this.hoVaTenDem = hoVaTenDem;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public KhachHangDTO(int id, String diaChi, String email, String hoVaTenDem, String soDienThoai, String ten) {
		super();
		this.id = id;
		this.diaChi = diaChi;
		this.email = email;
		this.hoVaTenDem = hoVaTenDem;
		this.soDienThoai = soDienThoai;
		this.ten = ten;
	}
	
	
}
