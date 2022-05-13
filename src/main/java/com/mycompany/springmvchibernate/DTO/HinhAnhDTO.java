package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mycompany.springmvchibernate.Entity.Ram;

public class HinhAnhDTO {
	
	private int id;
	private String hinhAnh;
	private Ram ram;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
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
		
		this.hinhAnh = hinhAnh;
	}
	public HinhAnhDTO(int id, String hinhAnh) {
		
		this.id = id;
		this.hinhAnh = hinhAnh;
	}
	
	@Transient
    public String getPhotosImagePath() {
        if (hinhAnh == null) return null;
        return "/product-photos/" + sanPham.getTen() + "/" + hinhAnh;
    }
	
}
