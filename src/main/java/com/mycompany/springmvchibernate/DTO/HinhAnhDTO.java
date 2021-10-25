package com.mycompany.springmvchibernate.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class HinhAnhDTO {
	
	private int id;
	private String hinhAnh;
	
	private SanPhamDTO sanPham;
	
	public SanPhamDTO getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPhamDTO sanPhamDTO) {
		this.sanPham = sanPhamDTO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	public HinhAnhDTO() {
	
	}
	
	public HinhAnhDTO(String hinhAnh) {
		super();
		this.hinhAnh = hinhAnh;
	}
	public HinhAnhDTO(int id, String hinhAnh) {
		
		this.id = id;
		this.hinhAnh = hinhAnh;
	}
	
}
