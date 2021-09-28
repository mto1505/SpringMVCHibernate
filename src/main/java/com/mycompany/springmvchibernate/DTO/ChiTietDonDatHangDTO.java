package com.mycompany.springmvchibernate.DTO;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mycompany.springmvchibernate.Entity.ChiTietDonDatHangPK;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.DonDatHang;

public class ChiTietDonDatHangDTO {

	private int idDdh;

	private String idCtsp;
	
	private int soLuong;

	private ChiTietSanPhamDTO chiTietSanPham;

	
	public int getIdDdh() {
		return idDdh;
	}


	public void setIdDdh(int idDdh) {
		this.idDdh = idDdh;
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


	public ChiTietSanPhamDTO getChiTietSanPham() {
		return chiTietSanPham;
	}


	public void setChiTietSanPham(ChiTietSanPhamDTO chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}


	public DonDatHang getDonDatHang() {
		return donDatHang;
	}


	public void setDonDatHang(DonDatHang donDatHang) {
		this.donDatHang = donDatHang;
	}


	private DonDatHang donDatHang;

	
}
