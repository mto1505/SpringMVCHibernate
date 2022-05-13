package com.mycompany.springmvchibernate.DTO;

import java.util.List;

public class GioHangDTO {
	
	private int id;
	private List<ChiTietGioHangDTO> chiTietGioHangs;
	
	
	public List<ChiTietGioHangDTO> getChiTietGioHangs() {
		return chiTietGioHangs;
	}

	public void setChiTietGioHangs(List<ChiTietGioHangDTO> chiTietGioHangs) {
		this.chiTietGioHangs = chiTietGioHangs;
	}

	public GioHangDTO() {
	
	}

	/*public KhachHangDTO getKhachHangs() {
		return khachHangs;
	}

	public void setKhachHangs(KhachHangDTO khachHangs) {
		this.khachHangs = khachHangs;
	}*/

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GioHangDTO(int id) {
		
		this.id = id;
	}
	
	
}
