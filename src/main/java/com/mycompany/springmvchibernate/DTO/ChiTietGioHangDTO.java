package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;

public class ChiTietGioHangDTO {
	
	private int idGh;
	private String idCtsp;
	
	private int soLuong;

	public int getIdGh() {
		return idGh;
	}

	public void setIdGh(int idGh) {
		this.idGh = idGh;
	}

	public String getIdCtsp() {
		return idCtsp;
	}

	public void setIdCtsp(String idCtsp) {
		this.idCtsp = idCtsp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
