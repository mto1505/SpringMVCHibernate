package com.mycompany.springmvchibernate.DTO;



public class ChiTietGioHangDTO {
	
	private int idIdGh;
	private int idIdCtsp;
	
	private ChiTietSanPhamDTO chiTietSanPham;
	
	
	private int soLuong;

	

	
	public ChiTietGioHangDTO() {
		
	}

	public ChiTietGioHangDTO(int idIdGh, int idIdCtsp, ChiTietSanPhamDTO chiTietSanPham, int soLuong) {
		
		this.idIdGh = idIdGh;
		this.idIdCtsp = idIdCtsp;
		this.chiTietSanPham = chiTietSanPham;
		this.soLuong = soLuong;
	}

	public int getIdIdGh() {
		return idIdGh;
	}

	public void setIdIdGh(int idIdGh) {
		this.idIdGh = idIdGh;
	}

	public int getIdIdCtsp() {
		return idIdCtsp;
	}

	public void setIdIdCtsp(int idIdCtsp) {
		this.idIdCtsp = idIdCtsp;
	}

	public ChiTietSanPhamDTO getChiTietSanPham() {
		return chiTietSanPham;
	}

	public void setChiTietSanPham(ChiTietSanPhamDTO chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
